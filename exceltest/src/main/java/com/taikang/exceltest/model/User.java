package com.taikang.exceltest.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.taikang.exceltest.converter.LocalDateTimeConverter;
import com.taikang.exceltest.converter.SexConverter;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @className User
 * @author:ShanXuerui
 * @date 2020/10/20 15:23
 */
@Data
public class User {
    @ExcelProperty(value = "姓名", index = 0)
    @ColumnWidth(100)
    private String name;
        @ExcelProperty(value = "年龄", index = 1)
//    @ExcelIgnore//默认所有字段都会和excel去匹配，加了这个注解会忽略该字段
    private String age;
        @ExcelProperty(value = "性别", index = 2,converter = SexConverter.class)
//    @ExcelProperty(value = "性别", index = 2)
    private Integer sex;

    @ExcelProperty(value = "创建时间", index = 3, converter = LocalDateTimeConverter.class)
    private LocalDateTime createTime;


    public User(String name, String age, Integer sex, LocalDateTime createTime) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.createTime = createTime;
    }

    public User(String name, String age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }
}
