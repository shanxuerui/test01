package com.taikang.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @className Lock
 * @author:ShanXuerui
 * @date 2021/1/14 14:31
 */
//分布式锁
public class Lock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private LockThread lockThread;

    private Boolean setLock(String key) {
        SessionCallback<Boolean> sessionCallback = new SessionCallback<Boolean>() {
            List<Object> exec = null;

            @Override
            @SuppressWarnings("unchecked")
            public Boolean execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                //低版本的redis，分两步，一部设置key,一部设置过期时间。采取redis事务
                stringRedisTemplate.opsForValue().setIfAbsent(key, UUID.randomUUID().toString());
                stringRedisTemplate.expire(key, 30, TimeUnit.SECONDS);
                exec = operations.exec();
                if (exec.size() > 0) {
                //返回的集合中是两个bollean值，代表第一步，第二步，是否执行成功
                    return (Boolean) exec.get(0);
                }
                return false;
            }
        };
        return stringRedisTemplate.execute(sessionCallback);
    }


    private Boolean HasLock(String key, String Newvalue) {
//高版本的redis可以一步实现，设置key,设置过期时间
        Boolean couldset = stringRedisTemplate.opsForValue().setIfAbsent(key, Newvalue, 30, TimeUnit.SECONDS);

        if (couldset) {
            lockThread.DaemonThread(key, Newvalue);
            return false;
        } else {
            return true;
        }
    }
}
