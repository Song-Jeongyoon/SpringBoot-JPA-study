package com.example.mapping.OneToOneIdentification;

import javax.persistence.*;

@Entity
public class BoardDetail {

    @Id
    private Long BoardId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    private String content;
    //...
}
