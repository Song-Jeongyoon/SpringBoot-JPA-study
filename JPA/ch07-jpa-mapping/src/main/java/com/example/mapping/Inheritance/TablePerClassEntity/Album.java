package com.example.mapping.Inheritance.TablePerClassEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
    //...
}

