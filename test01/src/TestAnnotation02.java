import java.lang.reflect.Method;

public class TestAnnotation02 {
    public static void main(String[] args){
//        isAnnotationPresent(Class<? extends Annotation> annotationClass)方法是专门判断该元素上是否配置有某个指定的注解；
//        getAnnotation(Class<A> annotationClass)方法是获取该元素上指定的注解。之后再调用该注解的注解类型元素方法就可以获得配置时的值数据；
//        反射对象上还有一个方法getAnnotations()，该方法可以获得该对象身上配置的所有的注解。它会返回给我们一个注解数组，需要注意的是该数组的类型是Annotation类型，这个Annotation是一个来自于java.lang.annotation包的接口。

        try {
            //获取Test01的Class对象
            Class Test01 = Class.forName("Test01");


            Method queryChannel = Test01.getMethod("queryChannel");

            if(queryChannel.isAnnotationPresent(MethodLog.class)){
                System.out.println("Test01类上配置了MethodLog注解！");
                //获取该元素上指定类型的注解
                MethodLog cherryAnnotation = queryChannel.getAnnotation(MethodLog.class);
                System.out.println("value: " + cherryAnnotation.value() + ", isLogReturn: " + cherryAnnotation.isLogReturn());
            }else{
                System.out.println("Test01类上没有配置MethodLog注解！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
