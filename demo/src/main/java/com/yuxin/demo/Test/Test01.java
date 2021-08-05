package com.yuxin.demo.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className Test01
 * @author:ShanXuerui
 * @date 2020/10/19 14:34
 */
@Controller
public class Test01 {
    @RequestMapping("/test")
    public @ResponseBody Object test(){

        return "第一个SpringBoot工程";
}
}
