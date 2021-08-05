package com.taikang.exceltest.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.taikang.exceltest.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @className ExcelTest03
 * @author:ShanXuerui
 * @date 2020/10/21 15:54
 */
@RestController
@Log4j2
public class ExcelTest03 {

    @RequestMapping("/uploadTest")

    public void importData(MultipartFile file)  {
        System.out.println("==================begin");
        if (file == null) return;
        ArrayList<Object> list = new ArrayList<>();
        AnalysisEventListener listener = new AnalysisEventListener() {
            @Override
            public void invoke(Object data, AnalysisContext context) {
                list.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                log.info("导入数据完毕");
            }
        };
        try {
            User user = new User();

            EasyExcel.read(file.getInputStream(), user.getClass(), listener).sheet(0).doRead();

        } catch (IOException e) {
            log.error("导入出错：{}", e.getMessage());
        }
        list.forEach(System.out::println);
        System.out.println("==================over");
    }



}
