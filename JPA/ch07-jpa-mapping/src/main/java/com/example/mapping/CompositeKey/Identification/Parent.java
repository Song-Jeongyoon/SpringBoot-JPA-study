package com.example.mapping.CompositeKey.Identification;

import javax.persistence.*;

@Entity
public class Parent {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private String id;

    private String name;
    //...
}

