package com.example.mapping.Inheritance.JoinStragetyEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    // 추상클래스 상속받으므로 id 선언 불필요
    private String Artist;
    // ...
}
