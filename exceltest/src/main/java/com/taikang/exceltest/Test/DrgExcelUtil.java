package com.taikang.exceltest.Test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.taikang.exceltest.converter.LocalDateTimeConverter;
import com.taikang.exceltest.converter.LocalDateTimeConverter02;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @className DrgExcelUtil
 * @author:ShanXuerui
 * @date 2020/10/22 11:18
 */
public class DrgExcelUtil {
    public static void writeExcel(HttpServletResponse response, List<? extends Object> data, String fileName, String sheetName, Class clazz) throws Exception {
        //表头样式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        OutputStream outputStream = getOutputStream(fileName, response);
        EasyExcel.write(outputStream,clazz).excelType(ExcelTypeEnum.XLSX).sheet(sheetName).registerConverter(new LocalDateTimeConverter()).registerWriteHandler(horizontalCellStyleStrategy).doWrite(data);
    }
    public static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        return response.getOutputStream();
    }



    //    表头封装
    public static List<List<String>> head(String [] srts) {
        List<List<String>> head = new ArrayList<>();

        for (int i = 0; i < srts.length; i++) {
            List<String> list = new ArrayList<>();
            list.add(srts[i]);
            head.add(list);
        }
        return head;
    }


    public static void dynamicHeadWrite(HttpServletResponse response, List<? extends Object> data, String fileName, String sheetName, List<List<String>> head) throws Exception {
        //表头样式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        OutputStream outputStream = getOutputStream(fileName, response);
        EasyExcel.write(outputStream).
                head(head).
                excelType(ExcelTypeEnum.XLSX).
                sheet(sheetName).registerConverter(new LocalDateTimeConverter02()).
                registerWriteHandler(horizontalCellStyleStrategy).
                registerWriteHandler(new AutomaticAdaptWidth()).//根据表头或者表中数据的长度来自动设置列的宽度，避免如下情况，列中内容过长，第一个单元格的内容，延伸到下一个单元格的情况
                doWrite(data);


      /*  结算时间  入院时间 出院时间 总费用
          2020-10-22*/
      //结算时间跑到了入园时间这栏

    }
}
