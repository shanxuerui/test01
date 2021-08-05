package com.taikang.async.AsyncTask;

/**
 * @className RunTask
 * @author:ShanXuerui
 * @date 2021/1/5 16:05
 */
public class RunTask implements Runnable {

    private String name;

    public RunTask(String name) {
        this.name = name;
    }

    public RunTask() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run:" + Thread.currentThread().getName() + "--->" + i);
        }
    }
}
