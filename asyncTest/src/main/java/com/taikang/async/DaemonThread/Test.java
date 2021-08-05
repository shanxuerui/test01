package com.taikang.async.DaemonThread;

/**
 * @className Test
 * @author:ShanXuerui
 * @date 2021/2/26 15:39
 */
public class Test {
    public static void main(String[] args) {

        Thread thread = new Thread(new DemonTask());
//        1.守护线程
//        有一个特征，例如当主线程运行的时候，守护线程一起运行。
//        当主线程销毁，会和主线程一起销毁。
//        2.非守护线程
//        如果主线程销毁，用户线程继续运行且互不影响。
        thread.setDaemon(true);

        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            main---->9
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }

    }
}
