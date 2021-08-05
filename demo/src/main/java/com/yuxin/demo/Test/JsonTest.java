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
public class JsonTest {
    @RequestMapping("/testJson")
    @ResponseBody
    public  String test(@RequestBody User user){
        return user.getName()+"==="+user.getBirthday();
    }
}
