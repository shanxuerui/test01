package com.taikang.exceltest.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author itw_gongxy
 * @date 2019/12/12 15:23
 */
public class LocalDateTimeConverter02 implements Converter<LocalDate> {

    @Override
    public Class<LocalDate> supportJavaTypeKey() {
        return LocalDate.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public LocalDate convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(cellData.getStringValue(),dateTimeFormatter);
    }

    @Override
    public CellData<?> convertToExcelData(LocalDate value, ExcelContentProperty contentProperty,
                                          GlobalConfiguration globalConfiguration) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new CellData<>(dateTimeFormatter.format(value));
    }
}

