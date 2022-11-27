package com.example.ch08jpaproxy.lazyLoading;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {

    @Id
    private String id;
    private String username;
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    private Team team;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Order> orders;

    //...
}
