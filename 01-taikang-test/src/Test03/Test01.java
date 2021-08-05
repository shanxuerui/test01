package Test03;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @className Test01
 * @author:ShanXuerui
 * @date 2020/10/20 16:55
 */
public class Test01 {
    public static void main(String[] args) {
        String[] strs = {"姓名","年龄","地址"};

        List<List<String>> head = head(strs);

        for (List<String> list : head) {
            System.out.println(list);
        }

        List<String> tags = Lists.newArrayList("1","2","3");

        System.out.println(tags);
    }



    public static List<List<String>> head(String [] srts) {
        List<List<String>> head = new ArrayList<>();

        for (int i = 0; i < srts.length; i++) {
            List<String> list = new ArrayList<>();
            list.add(srts[i]);
            head.add(list);
        }
        return head;
    }


}
