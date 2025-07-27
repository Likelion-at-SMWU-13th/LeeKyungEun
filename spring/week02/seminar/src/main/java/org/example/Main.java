package org.example;


import org.example.bean.Lion;
import org.example.bean.Person;
import org.example.config.ProjectConfig;
import org.example.model.Comment;
import org.example.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // @Bean을 통해 빈 정의
//        Lion lion = context.getBean("lion", Lion.class);
//        System.out.println(lion.getName());
//        Lion lion1 = context.getBean("lion1", Lion.class);
//        System.out.println(lion1.getName());
//        String s = context.getBean(String.class);
//        System.out.println(s);
//        Integer n = context.getBean(Integer.class);
//        System.out.println(n);
        
        // @Component를 통해 빈 정의
//        Lion lion = context.getBean(Lion.class);
//        System.out.println(lion);
//        System.out.println(lion.getName());

        // 프로그래밍 방식으로 빈 정의
//        Lion lion = new Lion();
//        lion.setName("ribbon");
//
//        Supplier<Lion> lionSupplier = () -> lion;
//
//        context.registerBean("lion", Lion.class, lionSupplier);
//
//        Lion l = context.getBean(Lion.class);
//        System.out.println(l.getName());

        // 와이어링, 오토와이어링으로 빈 작성
//        Lion lion = context.getBean(Lion.class);
//        Person person = context.getBean(Person.class);
//
//        System.out.println("Person's name: " + person.getName());
//        System.out.println("Lion's name: " + lion.getName());
//        System.out.println("Person's lion: " + person.getLion());

        // @Autowired로 빈 작성
//        Person person = context.getBean(Person.class);
//
//        System.out.println("Person's name: " + person.getName());
//        System.out.println("Person's lion: " + person.getLion());

        Comment comment = new Comment();
        comment.setAuthor("babylion");
        comment.setText("I'm hungry");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
