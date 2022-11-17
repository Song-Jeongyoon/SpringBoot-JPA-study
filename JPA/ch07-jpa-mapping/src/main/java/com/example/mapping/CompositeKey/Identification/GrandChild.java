package com.example.mapping.CompositeKey.Identification;

import javax.persistence.*;

public class GrandChild {

    @MapsId("childId")
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "PARENT_ID"), @JoinColumn(name = "CHILD_ID")})
    private Child child;

    @EmbeddedId
    private String grandChildId;

    private String name;
}
