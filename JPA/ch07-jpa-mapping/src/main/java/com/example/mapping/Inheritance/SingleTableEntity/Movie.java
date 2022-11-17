package com.example.mapping.Inheritance.SingleTableEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    //...
}
