package com.example.mapping.CompositeKey.Identification;

import javax.persistence.Column;
import java.io.Serializable;

public class GrandChildId implements Serializable {

    private ChildId childId;

    @Column(name = "GRANDCHILD_ID")
    private String grandChildId;

    //equels, hashcode...
}
