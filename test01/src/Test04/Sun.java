package Test04;

/**
 * @className Sun
 * @author:ShanXuerui
 * @date 2020/11/19 20:40
 */
public class Sun extends Father {


    public Sun(String name) {
        super(name);
        System.out.println("子类构造方法");
    }



    static {
        System.out.println("子类静态（构造）代码块");
    }

    {
        System.out.println("子类（构造）代码块");
    }
}

