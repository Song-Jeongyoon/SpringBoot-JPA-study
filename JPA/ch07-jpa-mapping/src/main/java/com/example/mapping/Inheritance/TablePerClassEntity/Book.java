package com.example.mapping.Inheritance.TablePerClassEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Book extends Item {
    //...
}
