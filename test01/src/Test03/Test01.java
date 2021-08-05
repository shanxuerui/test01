package Test03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Test01
 * @Author:单雪瑞
 * @Date 2020/7/9 11:03
 */
public class Test01 {
    public static void main(String[] args) {
        String result = "123456789012345678901";
        // 签名的长度
//        String signLen = result.substring(0, 10);
//        String signLen = String.valueOf(result.substring(0, 10).length());
//        System.out.println(signLen);
//        String sign = result.substring(10, Integer.parseInt(signLen) + 10);
//        System.out.println(sign);
//        String data = result.substring(Integer.parseInt(signLen) + 10);
//        System.out.println(data);

        List<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add(list.size()/2, "ss");
        System.out.println(list);

        byte[] a = {97,65};


        File file = new File("E:\\nfs_share\\files\\ycpay\\download\\P1CLP1055.txt");
        String fileName = file.getName();
        System.out.println("文件"+fileName+"的大小是："+file.length());

//        FileInputStream fis  = null;
//        try {
//
//                String fileName = file.getName();
//                fis = new FileInputStream(file);
//                System.out.println("文件"+fileName+"的大小是："+fis.available()+"\n");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            if(null!=fis){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


    }
}
