package org.example;


import org.example.bean.Lion;
import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Lion lion = context.getBean("lion", Lion.class);
        System.out.println(lion.getName());
        Lion lion1 = context.getBean("lion1", Lion.class);
        System.out.println(lion.getName());
        String s = context.getBean(String.class);
        System.out.println(s);
        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}
