package com.example.mapping.JoinTable.OneToMany;

import javax.persistence.*;

@Entity
public class Child {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;

}
