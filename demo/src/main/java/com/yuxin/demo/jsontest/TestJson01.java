package com.yuxin.demo.jsontest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @className TestJson01
 * @author:ShanXuerui
 * @date 2021/1/4 16:24
 */
@RestController
public class TestJson01 {


    @PostMapping("test01")
    public User Test01(@RequestBody User user) {
        System.out.println("user.toString():"+user.toString());
        String userJsonStr = JSONObject.toJSONString(user);
        System.out.println("JSONObject.toJSONString(user):"+userJsonStr);
        return user;
    }

    @PostMapping("test02")
    public User Test02() {

        User user = new User();
        user.setBirthday11(new Date());
        user.setBirthday22(new Date());
        user.setBirthday33(new Date());
        user.setBirthday44("1997-09-22 12:12:12");


        System.out.println("user.toString():"+user.toString());
        System.out.println("JSONObject.toJSONString(user):"+JSONObject.toJSONString(user));
        return user;
    }

}
