package com.yuxin.demo.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className Student
 * @author:ShanXuerui
 * @date 2020/11/22 1:31
 */
public class Student {
    private String name;
    private String birthday;


    public String getName() {
        return name;
    }


    public String getBirthday() {
        if (birthday.length() == 16) {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date parse = null;
            try {
                parse = format.parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return format2.format(parse);

        } else {

            return birthday;
        }


    }
}
