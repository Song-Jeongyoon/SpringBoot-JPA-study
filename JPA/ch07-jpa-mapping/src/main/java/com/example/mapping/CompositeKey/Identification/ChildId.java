package com.example.mapping.CompositeKey.Identification;

import javax.persistence.Column;
import java.io.Serializable;

public class ChildId implements Serializable {

    private String parentId;

    @Column(name = "CHILD_ID")
    private String childId;

    //equels, hashcode...
}
