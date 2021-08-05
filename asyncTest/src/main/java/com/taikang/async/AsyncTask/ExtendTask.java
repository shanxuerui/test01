package com.taikang.async.AsyncTask;

/**
 * @className ExtendTask
 * @author:ShanXuerui
 * @date 2021/2/25 14:39
 */
public class ExtendTask extends Thread {

    private String name;

    public ExtendTask(String name) {
        this.name = name;
    }


    public void run() {
        System.out.println("ExtendTask:" + Thread.currentThread().getName() + "," + name);
    }
}
