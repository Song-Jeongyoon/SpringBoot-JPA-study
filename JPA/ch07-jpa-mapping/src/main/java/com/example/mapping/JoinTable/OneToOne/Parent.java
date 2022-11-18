package com.example.mapping.JoinTable.OneToOne;

import javax.persistence.*;

@Entity
public class Parent {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;

    @OneToOne
    @JoinTable(name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private Child child;
}
