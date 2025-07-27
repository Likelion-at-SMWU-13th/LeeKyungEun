package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "lee";

    //@Autowired
    private final Lion lion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lion getLion() {
        return lion;
    }

//    public void setLion(Lion lion) {
//        this.lion = lion;
//    }

    @Autowired
    public Person(Lion lion) {
        this.lion = lion;
    }
}
