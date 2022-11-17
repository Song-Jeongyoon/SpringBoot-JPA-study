package com.example.mapping.CompositeKey.Identification;

import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
public class Child {

    @MapsId("parnetId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    @EmbeddedId
    private String ChildId;

    private String name;
    //...
}
