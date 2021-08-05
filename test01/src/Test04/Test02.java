package Test04;

/**
 * @className Test02
 * @author:ShanXuerui
 * @date 2020/11/19 20:10
 */
public class Test02 {
    static String jingTaiChengYuan = "jingTaiChengYuan";
    String shiLiChengYuan = "shiLiChengYuan";

    public static void jingTaiFangFa() {
        System.out.println("静态方法，静态方法不属于具体对象,一般通过类名来调用");
    }

    public void shiLiFangFa() {
        System.out.println("实例方法");
    }


    public static void main(String[] args) {
        System.out.println("main");

        test01();

//        test02();

        test03();

    }


    public static void test01() {

        System.out.println(jingTaiChengYuan);

        jingTaiFangFa();

        System.out.println("test01()");
    }

    public  void test02() {

        System.out.println(jingTaiChengYuan);

        jingTaiFangFa();

        System.out.println(shiLiChengYuan);

        shiLiFangFa();

        System.out.println("test02()");

    }

    public static void test03() {
        System.out.println(jingTaiChengYuan);

        jingTaiFangFa();

//        System.out.println(shiLiChengYuan);
//
//        shiLiFangFa();


        System.out.println("test03()");

    }


}
