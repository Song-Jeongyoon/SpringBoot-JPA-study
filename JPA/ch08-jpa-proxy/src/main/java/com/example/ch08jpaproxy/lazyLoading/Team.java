package com.example.ch08jpaproxy.lazyLoading;

import javax.persistence.Entity;

@Entity
public class Team {

    private String name;

    public String getName() {
        return name;
    }
    //...
}
