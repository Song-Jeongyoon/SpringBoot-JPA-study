package com.example.mapping.CompositeKey.nonIdentification;

import javax.persistence.Column;
import java.io.Serializable;

public class ParentId implements Serializable {

    @Column(name = "PARENT_ID1")
    private String id1;
    @Column(name = "PARENT_ID2")
    private String id2;

    public ParentId() {}

    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    //equals, hashcode ...
}
