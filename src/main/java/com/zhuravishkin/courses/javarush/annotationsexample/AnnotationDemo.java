package com.zhuravishkin.courses.javarush.annotationsexample;

@MyAnnotation
public class AnnotationDemo {
    public static void main(String[] args) {
        AnnotationDemo annotationDemo = new AnnotationDemo();
        System.out.println(annotationDemo.getClass().getAnnotation(MyAnnotation.class));
    }
}
