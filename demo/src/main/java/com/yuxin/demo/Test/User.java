package com.yuxin.demo.Test;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @className User
 * @author:ShanXuerui
 * @date 2020/11/21 23:32
 */
public class User {

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date birthday;






    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
