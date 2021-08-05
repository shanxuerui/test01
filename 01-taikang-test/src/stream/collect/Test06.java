package stream.collect;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @className Test05
 * @author:ShanXuerui
 * @date 3030/10/15 16:45
 */
public class Test06 {
    public static void main(String[] args) {
        Food3 food = new Food3("苹果", 10.0, "1", "山西", 30);
        Food3 food2 = new Food3("苹果", 20.0, "1", "山西", 30);
        Food3 food3 = new Food3("苹果", 30.0, "3", "山西", 50);
        Food3 food4 = new Food3("香蕉", 40.0, "3", "河北", 10);
        Food3 food5 = new Food3("香蕉", 50.0, "3", "河北", 5);
        Food3 food6 = new Food3("梨子", 60.0, "1", "河北", 3);

        List<Food3> list = new ArrayList<Food3>();
        list.add(food);
        list.add(food2);
        list.add(food3);
        list.add(food4);
        list.add(food5);
        list.add(food6);
        //根据price，价格进行汇总
        Collector<Food3, ?, DoubleSummaryStatistics> summarizingDouble = Collectors.summarizingDouble(Food3::getPrice);
//对根据地区分组之后的价格进行汇总
        Collector<Food3, ?, Map<String, DoubleSummaryStatistics>> food3MapCollector = Collectors.groupingBy(Food3::getAddress, summarizingDouble);
        //完成汇总，得出不同地区的价格的个数，最大最小值，平均值，和
        Map<String, DoubleSummaryStatistics> collect = list.stream().collect(food3MapCollector);

        for (Map.Entry<String, DoubleSummaryStatistics> entry : collect.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println(collect);




        Map<String, List<Integer>> collect1 = list.stream().collect(Collectors.groupingBy(Food3::getAddress, Collectors.mapping(Food3::getSale, toList())));

        for (Map.Entry<String, List<Integer>> entry : collect1.entrySet()) {

            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println(collect1);

        Map<String, Integer> collect2 = list.parallelStream()
                .collect(Collectors.groupingBy(Food3::getAddress,
                        Collectors.mapping(Food3::getSale,
                                // 对结果求和
                                Collectors.reducing(0, Integer::sum))));

        for (Map.Entry<String, Integer> entry : collect2.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println(collect2);
    }
}
