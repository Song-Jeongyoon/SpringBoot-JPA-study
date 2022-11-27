package com.example.ch08jpaproxy;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Member {

    private String username;

    @ManyToOne
    private Team team;

    public Team getTeam() {
        return team;
    }

    public String getUsername() {
        return username;
    }
    //...
}

