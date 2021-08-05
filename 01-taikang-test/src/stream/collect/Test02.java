package stream.collect;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @className Test02
 * @author:ShanXuerui
 * @date 2020/10/15 9:48
 */
public class Test02 {
    public static void main(String[] args) {

        List list = new ArrayList();


//        list.stream().collect(Collectors.toMap(, , ));
//
//        Map map = new HashMap();
//        map.put("1", "1");
//        map.put("1", "2");
//        map.put("1", "3");
//        System.out.println(map.get("1"));
//
//        List list1 = new ArrayList();
//
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//
//        System.out.println(list1.get(0));
//
//        String[] a = {"a","b","c"};
//        System.out.println(a[0]);
//
//
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6);
//        reduce 归纳
        Integer reduce = list3.stream().reduce(10, Integer::sum);
        System.out.println(list3.stream().reduce(Math::max).get());
        System.out.println(reduce);


    }
}
