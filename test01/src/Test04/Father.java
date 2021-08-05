package Test04;

/**
 * @className Father
 * @author:ShanXuerui
 * @date 2020/11/19 20:39
 */
public class Father {
    String name;


    public Father(String name) {
        System.out.println("父类构造方法");
    }

    static {
        System.out.println("父类静态（构造）代码块");
    }

    {
        System.out.println("父类（构造）代码块");
    }
}
