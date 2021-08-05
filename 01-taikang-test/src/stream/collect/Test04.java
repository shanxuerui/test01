package stream.collect;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @className Test04
 * @author:ShanXuerui
 * @date 2020/10/15 15:01
 */
public class Test04 {
    public static void main(String[] args) {
        Food2 food = new Food2("苹果", new BigDecimal(10), "1", "山西", 30);
        Food2 food2 = new Food2("苹果", new BigDecimal(30), "1", "山西", 30);
        Food2 food3 = new Food2("苹果", new BigDecimal(30), "2", "山西", 50);
        Food2 food4 = new Food2("香蕉", new BigDecimal(10), "2", "河北", 10);
        Food2 food5 = new Food2("香蕉", new BigDecimal(50), "2", "河北", 5);
        Food2 food6 = new Food2("梨子", new BigDecimal(60), "1", "河北", 2);

        List<Food2> list = new ArrayList<Food2>();
        list.add(food);
        list.add(food2);
        list.add(food3);
        list.add(food4);
        list.add(food5);
        list.add(food6);

        //根据价格分组
        Map<BigDecimal, List<Food2>> collect1 = list.stream().collect(Collectors.groupingBy(Food2::getPrice));
        for (Map.Entry<BigDecimal, List<Food2>> bigDecimalListEntry : collect1.entrySet()) {
            System.out.println(bigDecimalListEntry.getKey() + ":" + bigDecimalListEntry.getValue());
        }
        //根据价格分组后，再把每组的销量相加
        Map<BigDecimal, Integer> collect2 = list.stream().collect(Collectors.groupingBy(Food2::getPrice, Collectors.reducing(0, Food2::getSale, Integer::sum)));
        for (Map.Entry<BigDecimal, Integer> bigDecimalIntegerEntry : collect2.entrySet()) {
            System.out.println(bigDecimalIntegerEntry.getKey() + ":" + bigDecimalIntegerEntry.getValue());
        }

        list.stream().forEach(foods -> foods.setName(String.format("雪瑞的：%s",foods.getName())));

        for (Food2 food21 : list) {
            System.out.println(food21);
        }

    }
}
