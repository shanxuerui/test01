package stream.collect;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @className Test03
 * @author:ShanXuerui
 * @date 2020/10/15 13:59
 */
public class Test03 {
    public static void main(String[] args) {
        Food food = new Food("苹果", new BigDecimal(10), "1", "山西");
        Food food2 = new Food("苹果", new BigDecimal(30), "1", "山西");
        Food food3 = new Food("苹果", new BigDecimal(30), "2", "山西");
        Food food4 = new Food("苹果", new BigDecimal(10), "2", "河北");
        Food food5 = new Food("苹果", new BigDecimal(50), "2", "河北");
        Food food6 = new Food("苹果", new BigDecimal(30), "1", "河北");

        List<Food> list = new ArrayList<Food>();
        list.add(food);
        list.add(food2);
        list.add(food3);
        list.add(food4);
        list.add(food5);
        list.add(food6);

        Map<String, List<Food>> collect = list.stream().collect(Collectors.groupingBy(Food::getAddress));

        for (Map.Entry<String, List<Food>> stringListEntry : collect.entrySet()) {
            System.out.println(stringListEntry.getKey()+","+stringListEntry.getValue());
        }
//        reduce 归纳

//      归纳出最贵的食物的价格
        Optional<BigDecimal> reduce = list.stream().map(Food::getPrice).reduce(BigDecimal::min);
        Optional<BigDecimal> reduce1 = list.stream().map(Food::getPrice).reduce(BigDecimal::max); list.stream().map(Food::getPrice).reduce(BigDecimal::max);

        System.out.println(reduce.get());
        System.out.println(reduce1.get());


        Map<String, BigDecimal> medicines = list.parallelStream()
                .filter(x -> x.getId() == "2" )
                .collect(Collectors.groupingBy(Food::getAddress,
                        Collectors.reducing(BigDecimal.valueOf(7),
                                Food::getPrice,
                                BigDecimal::add)));

        for (Map.Entry<String, BigDecimal> stringBigDecimalEntry : medicines.entrySet()) {
            System.out.println(stringBigDecimalEntry.getKey()+":"+stringBigDecimalEntry.getValue());
        }
    }
}
