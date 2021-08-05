package com.taikang.exceltest.Test;

import com.taikang.exceltest.model.User;
import org.thymeleaf.expression.Lists;


import java.util.ArrayList;
import java.util.List;

/**
 * @className Test
 * @author:ShanXuerui
 * @date 2020/10/22 14:10
 */
public class Test {
    public static void main(String[] args) {

        User user = new User();
        user.setName("熊大");
        user.setAge("10");
        List<Object> list = new ArrayList<>();

        list.add(user.getName());
        list.add(user.getAge());
        list.add(user.getSex());
        list.add(user.getCreateTime());

        System.out.println(list.toString());
    }
}
