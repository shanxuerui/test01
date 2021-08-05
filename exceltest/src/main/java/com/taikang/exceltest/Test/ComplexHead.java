package com.taikang.exceltest.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;

/**
 * @className ComplexHead
 * @author:ShanXuerui
 * @date 2020/10/23 10:02
 */
@Controller
public class ComplexHead {

    @RequestMapping("/complexHead")
    public void export(HttpServletResponse response) {
        //表头封装

        List<List<String>> head = Lists.newArrayList(
                Lists.newArrayList("姓名", "大名"),
                Lists.newArrayList("姓名", "小名"),
                Lists.newArrayList("年龄", "虚岁"),
                Lists.newArrayList("年龄", "周岁"),
                Lists.newArrayList("联系方式", "手机号"),
                Lists.newArrayList("联系方式", "微信号"),
                Lists.newArrayList("联系方式", "QQ号"));

//      List<String> data = Lists.newArrayList("单雪瑞", "三牛", "24", "23", "15735180884", "xuerui922", "764795838");
//        data是List<String> 表格中没有数据

        List<List<String>> data = new ArrayList<>();

        List<String> list = Lists.newArrayList("单雪瑞", "三牛", "24", "23", "15735180884", "xuerui922", "764795838");     //data是List<List<String>> 表中有数据
        data.add(list);
        try {
            DrgExcelUtil.dynamicHeadWrite(response, data, "test", "test", head);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
