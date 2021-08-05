package com.taikang.async.DaemonThread;

/**
 * @className DemonTask
 * @author:ShanXuerui
 * @date 2021/2/26 15:40
 */
public class
DemonTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run:" + Thread.currentThread().getName() + "---->" + i);
        }
    }
}
