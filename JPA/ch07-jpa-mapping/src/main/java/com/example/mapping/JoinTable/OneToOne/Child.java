package com.example.mapping.JoinTable.OneToOne;

import javax.persistence.*;

@Entity
public class Child {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "child")
    private Parent parent;
}
