package com.yuxin.demo.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className JsonTest
 * @author:ShanXuerui
 * @date 2020/11/21 23:31
 */
@Controller
public class JsonTest02 {
    @RequestMapping("/testJson02")
    @ResponseBody
    public  String test(@RequestBody Student student){
        return student.getName()+"---"+student.getBirthday();
    }
}
