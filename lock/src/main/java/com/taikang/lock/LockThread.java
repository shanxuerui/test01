package com.taikang.lock;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
//守护线程，为redis续期
@Component
public class LockThread {

    private final StringRedisTemplate stringRedisTemplate;
    public LockThread(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
    @Async
    public void DaemonThread(String key, String Newvalue) {
        try {
            if (Newvalue.equals(stringRedisTemplate.opsForValue().get(key))) {
                stringRedisTemplate.expire(key, 30, TimeUnit.SECONDS);
                Thread.sleep(10000);
                DaemonThread(key, Newvalue);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}