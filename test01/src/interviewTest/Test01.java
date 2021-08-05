package interviewTest;

/**
 * @className Test01
 * @author:ShanXuerui
 * @date 2020/9/23 22:19
 */
public class Test01 {
    public static void main(String[] args) {

//        String a = "1";
//        String b = "1";
//
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
//
//        b = "2";
//
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
//
//        String aa = "11";
//        String bb = "1"+"1";
//
//        System.out.println(aa==bb);

//
//        String aa = "11";
//        String bb = "1"+"1";
//
//        System.out.println(aa==bb);
//        System.out.println(aa.equals(bb));


//        String aa =  new String("11");
//        String bb = "1"+"1";
//
//        System.out.println(aa==bb);
//        System.out.println(aa.equals(bb));
//为了减少在JVM中创建的字符串的数量，字符串类维护了一个字符串池，每当代码创建字符串常量时，JVM会首先检查字符串常量池。如果字符串已经存在池中， 就返回池中的实例引用。如果字符串不在池中，就会实例化一个字符串并放到池中。Java能够进行这样的优化是因为字符串是不可变的，可以不用担心数据冲突 进行共享
//    字符串常量总是指向字符串池中的一个对象。通过new操作符创建的字符串对象不指向字符串池中 的任何对象，但是可以通过使用字符串的intern()方法来指向其中的某一个。java.lang.String.intern()返回一个保留池字符 串，就是一个在全局字符串池中有了一个入口。如果以前没有在全局字符串池中，那么它就会被添加到里面
        String aa =  new String("11");//一个字符串对象在字符串常量池外创建，即使池里存在相同的字符串。考虑到这些，要避免new一个字符串除非你明确的知道需要这么做
        String cc =  new String("11");
        String bb = "11";
        String dd = "11";//使用相同的字符序列而不是使用new关键字创建的两个字符串会创建指向Java字符串常量池中的同一个字符串的指针。字符串常量池是Java节约资源的一种方式。
        String ee = "1"+"1"; //String a="1"+"1";会被直接优化成String a="11";
        System.out.println(aa==bb);
        System.out.println(aa==cc);
        System.out.println(bb==dd);//面试所问  字符串常量池
        System.out.println(bb==ee);//面试所问
        System.out.println(aa==ee);
    }
}
