package stream.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @className Test09
 * @author:ShanXuerui
 * @date 2021/2/25 15:31
 */
public class Test09 {
    public static void main(String[] args) {

        Food3 food = new Food3("苹果", 20.0, "1", "山西", 30);
        Food3 food2 = new Food3("苹果", 20.0, "1", "山西", 30);
        Food3 food3 = new Food3("吉县苹果", 30.0, "3", "山西", 50);
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

        Map<String, Food3> collect = list.stream().collect(Collectors.toMap(Food3::getAddress, x -> x, (k1, k2) -> k1));

//        for (Map.Entry<String, Food3> entry : collect.entrySet()) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }


//        Map<String, Food3> collect = list.stream().collect(Collectors.toMap(x->x.address, x -> x, (k1, k2) -> k2));
//
//        for (Map.Entry<String, Food3> entry : collect.entrySet()) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }

        Map<String, List<Food3>> collect1 = list.stream().collect(Collectors.groupingBy(item -> item.getAddress() +item.getPrice()));

        for (Map.Entry<String, List<Food3>> stringListEntry : collect1.entrySet()) {
            System.out.println(stringListEntry.getKey()+":"+stringListEntry.getValue());
        }

    }
}
