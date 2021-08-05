package com.yuxin.demo.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className Test02
 * @author:ShanXuerui
 * @date 2020/11/22 0:04
 */
public class Test02 {
    public static void main(String[] args) {
        System.out.println("1:"+test("1997-09-22 12:12"));//t
        System.out.println("2:"+test("1997-09-22 12:12:12"));//t
        System.out.println("3:"+test("1997-09-22 12:59"));//t
        System.out.println("4:"+test("1997-09-22 12:122"));//f
        System.out.println("5:"+test("1997-09-22 12:12abc"));//t
        System.out.println("6:"+test("abc1997-09-22 12:12"));//f

    }


    public static Boolean test(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        format.setLenient(false);

        try {
            Date parse = format.parse(time);
            System.out.println(parse);
            return true;
        } catch (ParseException e) {
          return false;
        }
    }
}
