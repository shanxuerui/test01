package Test04;

/**
 * @className Test03
 * @author:ShanXuerui
 * @date 2020/11/19 20:42
 */
public class Test03 {
    public static void main(String[] args) {

     /* 父类静态（构造）代码块
        子类静态（构造）代码块
        父类（构造）代码块
        父类构造方法
        子类（构造）代码块
        子类构造方法*/

         /*
            程序执行过程
                1)在main方法中使用了MyClass5类,需要先把MyClass5加载到内存
                        在方法区中给静态变量分配存储空间
                        执行类的静态 构造代码块
                2) new 运算符创建MyClass5对象, 系统会给对象的属性进行默认初始化
                3) 调用了MyClass5构造方法, 在构造方法体执行前:
                        会先执行字段的显示初始化
                        会执行构造代码块
                        再执行构造方法体
         */

        Sun sun = new Sun("熊大");


    }
}
