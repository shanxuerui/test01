package stream.collect;

/**
 * @className Test01
 * @author:ShanXuerui
 * @date 2020/10/14 13:25
 */
public class Test01 {
    public static void main(String[] args) {
        String abc = String.format("validatecode:%s", "abcdef");
        String abc1 = String.format("这个固定不动:%s", "这是后面的");

        System.out.println(abc);
        System.out.println(abc1);

        String name = "ShanXuerui";

        String format = String.format("姓名：%s", name);

        System.out.println(format);


        String format1 = String.format("%s%s生成绩效分析服务能力：区域:%s,时间：%s", "1", "2", "3", "4");

        System.out.println(format1);
    }
}
