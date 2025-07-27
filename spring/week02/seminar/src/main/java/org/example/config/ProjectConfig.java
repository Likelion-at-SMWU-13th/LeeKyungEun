package org.example.config;

import org.example.bean.Lion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {

//    @Bean
//    Lion lion() {
//        Lion lion = new Lion();
//        lion.setName("lee");
//        return lion;
//    }
//
//    @Bean
//    Lion lion1() {
//        Lion lion = new Lion();
//        lion.setName("lee");
//        return lion;
//    }
//
//    @Bean
//    String hello() {
//        return "hello";
//    }
//
//    @Bean
//    Integer one() {
//        return 1;
//    }

}
