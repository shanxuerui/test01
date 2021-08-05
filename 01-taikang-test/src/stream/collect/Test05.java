package stream.collect;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @className Test05
 * @author:ShanXuerui
 * @date 2020/10/15 16:45
 */
public class Test05 {
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
//summarizing汇总
//参数是Food2::getSale 销量，所以对销量进行汇总
        Collector<Food2, ?, IntSummaryStatistics> summarizingInt = Collectors.summarizingInt(Food2::getSale);

        System.out.println(summarizingInt);
//groupingBy(Food2::getName, summarizingInt);  根据名称分组，分组之后对得到summarizingInt的参数Food2::getSale，销量 进行汇总，得出 个数，最大最小，平均值，和。
        Collector<Food2, ?, Map<String, IntSummaryStatistics>> food2MapCollector = Collectors.groupingBy(Food2::getName, summarizingInt);

        System.out.println(food2MapCollector);

        Map<String, IntSummaryStatistics> collect = list.parallelStream().collect(food2MapCollector);

        for (Map.Entry<String, IntSummaryStatistics> entry : collect.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
