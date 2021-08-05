package com.taikang.exceltest.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.taikang.exceltest.converter.SexConverter;
import com.taikang.exceltest.model.TableHead;
import com.taikang.exceltest.model.User;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
/**
 * @className ExcelTest
 * @author:ShanXuerui
 * @date 2020/10/20 15:28
 */
@Log4j2
@Controller
public class ExcelTest {
    @RequestMapping ("/exportData")
    public void exportData(HttpServletResponse response) {
        List<User> list = getList();
        try {
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            String fileName = "三好学生表";
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xlsx");
            //单元格样式
            WriteCellStyle headwriteCellStyle = new WriteCellStyle();
            //居中对齐
            headwriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            //单元格样式
            WriteCellStyle contentwriteCellStyle = new WriteCellStyle();
            //居中对齐
            contentwriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            //第一个参数是表头样式，第二个参数是内容样式
            HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headwriteCellStyle,contentwriteCellStyle );
//使用User.class  user中的注解@ColumnWidth(100) 起作用，  name列的宽度为100
            EasyExcel.write(response.getOutputStream(), User.class).sheet("test").registerWriteHandler(horizontalCellStyleStrategy).registerConverter(new SexConverter()).doWrite(list);
//            姓名	年龄	性别	创建时间
//            熊大	10	男	2020-10-22 13:26:16
//            牛二	20	女	2020-10-22 13:26:16
//            张三	30	男	2020-10-22 13:26:16
//            李四	40	男	2020-10-22 13:26:16
//            王五	50	女	2020-10-22 13:26:16



        } catch (Exception e) {
            log.error("下载报表异常：{}", e.getMessage());
            throw new RuntimeException("下载报表异常");
        }
    }


    @RequestMapping ("/exportData02")
    public void exportData02(HttpServletResponse response) {
        List<User> list = getList();
        try {
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            String fileName = "三好学生表";
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xlsx");
            //单元格样式
            WriteCellStyle headwriteCellStyle = new WriteCellStyle();
            //居中对齐
            headwriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            //单元格样式
            WriteCellStyle contentwriteCellStyle = new WriteCellStyle();
            //居中对齐
            contentwriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            //第一个参数是表头样式，第二个参数是内容样式
            HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headwriteCellStyle,contentwriteCellStyle );

            EasyExcel.write(response.getOutputStream(), User.class).sheet("test").registerWriteHandler(horizontalCellStyleStrategy).doWrite(list);
        } catch (Exception e) {
            log.error("下载报表异常：{}", e.getMessage());
            throw new RuntimeException("下载报表异常");
        }
    }

    @RequestMapping ("/exportData03")
    public void exportData03(HttpServletResponse response) {
        List<User> list = new ArrayList<>();
        try {
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            String fileName = "三好学生表";
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xlsx");
            //List为空，所以只导出表头
            EasyExcel.write(response.getOutputStream(), User.class).sheet("test").doWrite(list);
        } catch (Exception e) {
            log.error("下载报表异常：{}", e.getMessage());
            throw new RuntimeException("下载报表异常");
        }
    }



    @RequestMapping ("/exportData04")
    public void exportData04(HttpServletResponse response) {
        List<User> list = new ArrayList<>();
        try {
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            String fileName = "三好学生表头";
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xlsx");
            //List为空，所以只导出表头
            EasyExcel.write(response.getOutputStream(), TableHead.class).sheet("test").doWrite(list);
        } catch (Exception e) {
            log.error("下载报表异常：{}", e.getMessage());
            throw new RuntimeException("下载报表异常");
        }
    }


    private List<User> getList() {
        List<User> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        User xd = new User("熊大", "10", 1, now);
        User ne = new User("牛二", "20", 0, now);
        User zs = new User("张三", "30", 1, now);
        User ls = new User("李四", "40", 1, now);
        User ww = new User("王五", "50", 0, now);
        list.add(xd);
        list.add(ne);
        list.add(zs);
        list.add(ls);
        list.add(ww);
        return list;
    }



    @RequestMapping("/import")
    public String index() {
        //模板页面，不是jsp

        return "index.html";
    }
}
