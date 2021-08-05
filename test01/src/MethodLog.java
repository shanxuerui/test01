import java.lang.annotation.*;

@Target(ElementType.METHOD)

//@Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。在Annotation类型的声明中使用了target可更加明晰其修饰的目标。

@Documented
//@Documented 注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的. 但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中，是一个标记注解，没有成员。
@Retention(RetentionPolicy.RUNTIME)

//注解@Retention可以用来修饰注解，是注解的注解，称为元注解。
//        Retention注解有一个属性value，是RetentionPolicy类型的，Enum RetentionPolicy是一个枚举类型，
//        这个枚举决定了Retention注解应该如何去保持，也可理解为Rentention 搭配 RententionPolicy使用。RetentionPolicy有3个值：CLASS  RUNTIME   SOURCE
//        按生命周期来划分可分为3类：
//        1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
//        2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
//        3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
public @interface MethodLog {

    /**
     * 方法功能
     *
     * @return
     */
    String value() default "中信消费金融支付小组";

    /**
     * 打印返回值
     *
     * @return
     */
    boolean isLogReturn() default true;

}