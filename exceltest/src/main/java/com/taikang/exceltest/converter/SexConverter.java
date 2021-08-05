package com.taikang.exceltest.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @className SexConverter
 * @author:ShanXuerui
 * @date 2020/10/20 16:11
 */
public class SexConverter implements Converter<Integer> {
    @Override
    public Class supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return "男".equals(cellData.getStringValue()) ? 1 : 0;
    }

    @Override
    public CellData convertToExcelData(Integer value, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        //所有integer类型的都会被转换，之前年龄也是integer类型，所以年龄也会转换，所以是1就是男，否则就是女，所有的年龄都不是1，所以，所有的年龄都被转换成女，所以导出的excel表格中，年龄一列全是女，后来将年龄改为String类型，String类型的不会被转换，所以年龄正常了。性别还是integer，所以性别1被准换为男，否则被转换成女。
        return new CellData(value.equals(1) ? "男" : "女");
    }
}
