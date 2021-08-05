package com.taikang.exceltest.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.taikang.exceltest.converter.SexConverter;
import com.taikang.exceltest.model.TableHead;
import com.taikang.exceltest.model.User;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @className ExcelTest
 * @author:ShanXuerui
 * @date 2020/10/20 15:28
 */
@Log4j2
@Controller
public class ExcelTest02 {


    private List<List<Object>> getList() {
        List<User> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        User xd = new User("熊大", "10", 1);
        User ne = new User("牛二", "20", 0);
        User zs = new User("张三", "30", 1);
        User ls = new User("李四", "40", 1);
        User ww = new User("王五", "50", 0);
        list.add(xd);
        list.add(ne);
        list.add(zs);
        list.add(ls);
        list.add(ww);

        List<List<Object>> data = new ArrayList<>();

        list.parallelStream().forEach(item -> {
            List<Object> itemList = new ArrayList<>();

            itemList.add(item.getAge());
            itemList.add(item.getAge());
            itemList.add(item.getName());
            itemList.add(item.getName());
            data.add(itemList);
        });

        return data;
    }


    private List<User> getList2() {
        List<User> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        User xd = new User("熊大", "10", 1);
        User ne = new User("牛二", "20", 0);
        User zs = new User("张三", "30", 1);
        User ls = new User("李四", "40", 1);
        User ww = new User("王五", "50", 0);
        User zl = new User("赵六", "50", 0);
        User cq = new User("陈七", "50", 0);
        User zb = new User("郑八", "50", 0);
        list.add(xd);
        list.add(ne);
        list.add(zs);
        list.add(ls);
        list.add(ww);
        list.add(zl);
        list.add(cq);
        list.add(zb);
        return list;
    }


    private List<List<String>>  getList3() {
        String[] arr = {"1","2","3"};
        List<List<String>> data = new ArrayList<>();
        for (String s : arr) {
            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add(s);
            data.add(list);
        }
        return data;
    }


    private List<String>  getList4() {

       List<String> list = new ArrayList<>();
       list.add("1");
       list.add("2");
       list.add("3");
      return list;
}



    private List<List<Object>> getList5() {
        User user = new User();
        user.setName("熊大");
        user.setAge("10");
        List<Object> list = new ArrayList<>();

        list.add(user.getName());
        list.add(user.getAge());
        list.add(user.getSex());
        list.add(user.getCreateTime());

        List<List<Object>> lists = new ArrayList<>();
        lists.add(list);
        return lists;
    }

    @RequestMapping("/exportData06")
    public void exportData02(HttpServletResponse response) {
        //data是表体中的数据
        List<User> data = getList2();//没有使用User.class,使用的自定义表头，user中的注解 @ColumnWidth(100) 不起作用，name列宽度不变
        // 当List中是User时，一行是一个User信息




//       List<List<Object>> data = getList();
       // 没有使用User.class,使用的自定义表头，user中的注解 @ColumnWidth(100) 不起作用，name列宽度不变
        // 当List中是List<Object>时，一行展示List中的一个元素，也就是一个List<Object>,然后List<Object>中的元素在一行从左往右显示，也就是每行都是Age，Age，Name,Name
//        30	30	张三	张三
//        40	40	李四	李四
//        50	50	王五	王五
//        20	20	牛二	牛二
//        10	10	熊大	熊大


//        List<List<String>> data = getList3();//一行展示一个List<String>中的内容，也就是（1,2,1）,（1,2,2）,（1,2,3）



        //   List<String> data = getList4();  //表体中无数据


//       List<List<Object>> data = getList5();
        // list.add(user.getSex()); list.add(user.getCreateTime());  sex和createTime为null,但是导出时不会报错，导出结果是：熊大	10        ，为null的sex,create直接为空



//表头参数有两个 1 List<List<String>>   2 Class
        //1  表头使用生成的List<List<String>>中的数据 表体使用data中的数据
        List<List<String>> head = head();
        try {

            dynamicHeadWrite(response, data, "三好学生表", "test", head);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dynamicHeadWrite(HttpServletResponse response, List<User> data, String fileName, String sheetName, List<List<String>> head) throws Exception {

        OutputStream outputStream = getOutputStream(fileName, response);

        //2  表头使用TableHead类中的表头，表体使用data中的数据
        TableHead head1 = new TableHead();

        EasyExcel.write(outputStream).head(head).excelType(ExcelTypeEnum.XLSX).sheet(sheetName).doWrite(data);

    }




    public static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        return response.getOutputStream();
    }


    public  List<List<String>> head() {

        List<List<String>> head = new ArrayList<>();
        String[] strs = {"姓名","年龄","性别","身高","体重","爱好","地址","自定义表头动态表头","参数是List<List<String>>"};
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            head.add(list);
        }
        return head;
    }
}


