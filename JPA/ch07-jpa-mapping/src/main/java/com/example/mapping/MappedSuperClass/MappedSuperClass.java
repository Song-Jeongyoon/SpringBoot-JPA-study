package com.example.mapping.MappedSuperClass;

import javax.persistence.*;

public class MappedSuperClass {

    @MappedSuperclass
    public abstract class BaseEntity {

        @Id @GeneratedValue
        private Long id;
        private String name;
    }

    @Entity
    public class Member extends BaseEntity {
        private String email;
    }

    @Entity
    public class Seller extends BaseEntity {
        private String shopName;
    }

}
