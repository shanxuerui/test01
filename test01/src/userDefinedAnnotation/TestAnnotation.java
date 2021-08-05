package userDefinedAnnotation;

import userDefinedAnnotation.CherryAnnotation;

import java.lang.reflect.Method;

public class TestAnnotation {
    public static void main(String[] args){
//        isAnnotationPresent(Class<? extends Annotation> annotationClass)方法是专门判断该元素上是否配置有某个指定的注解；
//        getAnnotation(Class<A> annotationClass)方法是获取该元素上指定的注解。之后再调用该注解的注解类型元素方法就可以获得配置时的值数据；
//        反射对象上还有一个方法getAnnotations()，该方法可以获得该对象身上配置的所有的注解。它会返回给我们一个注解数组，需要注意的是该数组的类型是Annotation类型，这个Annotation是一个来自于java.lang.annotation包的接口。

        try {
            //获取Student的Class对象
            Class stuClass = Class.forName("userDefinedAnnotation.Student");

            //说明一下，这里形参不能写成Integer.class，应写为int.class
            Method stuMethod = stuClass.getMethod("study",int.class);

            if(stuMethod.isAnnotationPresent(CherryAnnotation.class)){
                System.out.println("Student类上配置了CherryAnnotation注解！");
                //获取该元素上指定类型的注解
                CherryAnnotation cherryAnnotation = stuMethod.getAnnotation(CherryAnnotation.class);
                System.out.println("name: " + cherryAnnotation.name() + ", age: " + cherryAnnotation.age()
                    + ", score: " + cherryAnnotation.score()[0]+","+cherryAnnotation.score()[1]+","+cherryAnnotation.score()[2]);
            }else{
                System.out.println("Student类上没有配置CherryAnnotation注解！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
