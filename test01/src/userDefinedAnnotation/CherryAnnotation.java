package userDefinedAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface CherryAnnotation {
    String name();
    int age() default 18;
    int[] score() default {100,100,100};
}
