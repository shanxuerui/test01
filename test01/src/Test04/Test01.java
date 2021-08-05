package Test04;

/**
 * @className Test01
 * @author:ShanXuerui
 * @date 2020/11/19 20:09
 */
public class Test01 {
    public static void main(String[] args) {
//        静态方法不属于具体对象,一般通过类名来调用
//        Test02.jingTaiFangFa();
//
//
//
////        通过类名直接访问静态变量
//        System.out.println(Test02.jingTaiChengYuan);

        Test02 test02 = new Test02();

        System.out.println(test02.shiLiChengYuan);

        test02.shiLiFangFa();

        Test02.jingTaiFangFa();

        System.out.println(Test02.jingTaiChengYuan);



    }


    public void test() {
//        静态方法不属于具体对象,一般通过类名来调用
        Test02.jingTaiFangFa();
//        通过类名直接访问静态变量
        System.out.println(Test02.jingTaiChengYuan);


//        Test02.shiLiFangFa();

//        System.out.println(Test02.shiLiChengYuan);
    }


}
