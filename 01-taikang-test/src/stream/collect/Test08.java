package stream.collect;

import org.assertj.core.util.Lists;

import java.util.ArrayList;

/**
 * @className Test08
 * @author:ShanXuerui
 * @date 2020/10/23 14:25
 */
public class Test08 {
    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        list.stream().forEach(System.out::print);
        System.out.println();
        list.parallelStream().forEach(System.out::print);
//parallelStream提供了流的并行处理，它是Stream的另一重要特性，其底层使用Fork/Join框架实现。简单理解就是多线程异步任务的一种实现。
//        使用parallelStream后，结果并不按照集合原有顺序输出
//        parallelStream是利用多线程进行的
    }
}
