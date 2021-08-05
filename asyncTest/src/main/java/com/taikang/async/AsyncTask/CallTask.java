package com.taikang.async.AsyncTask;

import java.util.concurrent.Callable;

/**
 * @className CallTask
 * @author:ShanXuerui
 * @date 2021/1/6 10:14
 */
public class CallTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call:" + Thread.currentThread().getName());
        return "return call:" + Thread.currentThread().getName();
    }
}
