package com.taikang.async.AsyncTask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @className Task01
 * @author:ShanXuerui
 * @date 2021/1/5 16:02
 */
@Component
public class AsyncTask {

    @Async
    public void async(String name) {
        System.out.println("@Async:" + Thread.currentThread().getName()+","+name);
    }
}
