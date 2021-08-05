package com.taikang.async.url;

import com.taikang.async.AsyncTask.AsyncTask;
import com.taikang.async.AsyncTask.CallTask;
import com.taikang.async.AsyncTask.RunTask;
import com.taikang.async.DaemonThread.DemonTask;
import com.taikang.async.DaemonThread.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;


/**
 * @className AsyncController
 * @author:ShanXuerui
 * @date 2021/1/5 16:03
 */
@RestController
public class UrlTest {


    @RequestMapping("/urlTest")
    public void urlTask() {
//        E:\studyJava\Test\asyncTest
        System.out.println(this.getClass().getClassLoader().getResource("").getPath().substring(1));

        System.out.println(Paths.get(this.getClass().getClassLoader().getResource("").getPath().substring(1)));

    }
}

