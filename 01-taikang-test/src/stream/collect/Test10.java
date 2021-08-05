package stream.collect;


import java.util.stream.Stream;

/**
 * @className Test10
 * @author:ShanXuerui
 * @date 2021/3/2 10:49
 */
public class Test10 {

    public static void main(String[] args) {
        //    在Java 8中，我们可以使用Stream.iterate创建流值，即所谓的无限流。
        Stream.iterate(10, f->2*f+3).limit(8).forEach(System.out::println);
    }
}
