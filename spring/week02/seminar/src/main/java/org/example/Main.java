package org.example;


import org.example.bean.Lion;
import org.example.bean.Person;
import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        Lion lion = context.getBean("lion", Lion.class);
//        System.out.println(lion.getName());
//        Lion lion1 = context.getBean("lion1", Lion.class);
//        System.out.println(lion1.getName());
//        String s = context.getBean(String.class);
//        System.out.println(s);
//        Integer n = context.getBean(Integer.class);
//        System.out.println(n);

//        Lion lion = context.getBean(Lion.class);
//        System.out.println(lion);
//        System.out.println(lion.getName());

//        Lion lion = new Lion();
//        lion.setName("ribbon");
//
//        Supplier<Lion> lionSupplier = () -> lion;
//
//        context.registerBean("lion", Lion.class, lionSupplier);
//
//        Lion l = context.getBean(Lion.class);
//        System.out.println(l.getName());

        Lion lion = context.getBean(Lion.class);
        Person person = context.getBean(Person.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Lion's name: " + lion.getName());
        System.out.println("Person's lion: " + person.getLion());
    }
}
