package com.taikang.async.AsyncTask;

import com.taikang.async.DaemonThread.DemonTask;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;


/**
 * @className AsyncController
 * @author:ShanXuerui
 * @date 2021/1/5 16:03
 */
@RestController
public class AsyncController {


    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/asyncTest")
    public void task(String name) throws ExecutionException, InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            asyncTask.async(name);
//        }


//        for (int i = 0; i < 20; i++) {
//            new ExtendTask(name).start();
//        }


//        for (int i = 0; i < 20; i++) {
//            CallTask callTask = new CallTask();
//            FutureTask<String> futureTask = new FutureTask<String>(callTask);
//            new Thread(futureTask).start();
////            get()：返回Callable里call（）方法的返回值，调用这个方法会导致程序阻塞，必须等到子线程结束后才会得到返回值
//            System.out.println(futureTask.get());
//            System.out.println(Thread.currentThread().getName() + "========================");
//        }

        Thread thread = new Thread(new DemonTask());
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            http-nio-8080-exec-1---->9
//            守护线程受主线程影响，http-nio-8080-exec-1不是主线程，所以影响不了守护线程
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }


    }

    @RequestMapping("/asyncTest02")
    public void task02() {
        System.out.println("当前线程:" + Thread.currentThread().getName());

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 10, 50, TimeUnit.MILLISECONDS, queue);


        for (int i = 0; i < 10; i++) {
            poolExecutor.execute(new RunTask());
        }
        poolExecutor.shutdown();
    }

    @RequestMapping("/asyncTest03")
    public void task03() {
        System.out.println("当前线程:" + Thread.currentThread().getName());
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new RunTask());
            executorService.execute(new RunTask());
        }
    }

    @RequestMapping("/asyncTest04")
    public void task04() throws ExecutionException, InterruptedException {
        System.out.println("当前线程:" + Thread.currentThread().getName());
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            Future submit = executorService.submit(new CallTask());
//            get()：返回Callable里call（）方法的返回值，调用这个方法会导致程序阻塞，必须等到子线程结束后才会得到返回值
//            Object o = submit.get().toString();
//            System.out.println(o);
        }
        System.out.println("当前线程:" + Thread.currentThread().getName());


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });


        executorService.execute(() -> System.out.println("run"));
    }
}
