package com.yuxin.demo.jsontest;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @className User
 * @author:ShanXuerui
 * @date 2021/1/4 16:20
 */

public class User {

    private Date birthday11;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday22;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday33;

    private String birthday44;


    public User(Date birthday11, Date birthday22, Date birthday33, String birthday44) {
        this.birthday11 = birthday11;
        this.birthday22 = birthday22;
        this.birthday33 = birthday33;
        this.birthday44 = birthday44;
    }

    public User() {
    }

    public Date getBirthday11() {
        return birthday11;
    }

    public void setBirthday11(Date birthday11) {
        this.birthday11 = birthday11;
    }

    public Date getBirthday22() {
        return birthday22;
    }

    public void setBirthday22(Date birthday22) {
        this.birthday22 = birthday22;
    }

    public Date getBirthday33() {
        return birthday33;
    }

    public void setBirthday33(Date birthday33) {
        this.birthday33 = birthday33;
    }

    public String getBirthday44() {
        return birthday44;
    }

    public void setBirthday44(String birthday44) {
        this.birthday44 = birthday44;
    }

    @Override
    public String toString() {
        return "User{" +
                "birthday11=" + birthday11 +
                ", birthday22=" + birthday22 +
                ", birthday33=" + birthday33 +
                ", birthday44='" + birthday44 + '\'' +
                '}';
    }
}
