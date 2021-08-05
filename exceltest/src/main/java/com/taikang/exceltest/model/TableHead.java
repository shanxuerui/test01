package com.taikang.exceltest.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.taikang.exceltest.converter.LocalDateTimeConverter;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @className TableHead
 * @author:ShanXuerui
 * @date 2020/10/20 17:20
 */
@Data
public class TableHead {
    @ExcelProperty(value = "山西", index = 0)
    private String name;
    @ExcelProperty(value = "河北", index = 1)
    private Integer age;
    @ExcelProperty(value = "山东", index = 2)
    private Integer sex;
    @ColumnWidth(20)
    @ExcelProperty(value = "河南", index = 3 ,converter = LocalDateTimeConverter.class)
    private LocalDateTime createTime;

    @ExcelProperty(value = "用class中的表头", index = 4)
    private String head1;
    @ExcelProperty(value = "设定表头为这个类中的表头", index = 5)
    private String head2;
    @ExcelProperty(value = "参数是Class", index = 6)
    private String head3;


    public TableHead() {
    }
}
