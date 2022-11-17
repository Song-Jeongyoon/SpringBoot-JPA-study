package com.example.mapping.CompositeKey.nonIdentification;

import javax.persistence.*;

@Entity
public class Parent {

    @EmbeddedId
    private String id;

    private String name;
}
