package userDefinedAnnotation;

import userDefinedAnnotation.CherryAnnotation;

public class Student {
    @CherryAnnotation(name = "单雪瑞")
    public void study(int times){
        for(int i = 0; i < times; i++){
            System.out.println("Good Good Study, Day Day Up!");
        }
    }
}
