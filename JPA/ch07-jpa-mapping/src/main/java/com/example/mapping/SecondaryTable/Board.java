package com.example.mapping.SecondaryTable;

import javax.persistence.*;

@Entity
@Table(name = "BOARD")
@SecondaryTable(name = "BOARD_DETAIL",
    // 매핑할 다른 테이블의 기본 키 컬럼 속성
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID"))
public class Board {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;

    // 지정하지 않으면 기본 테이블에 매핑됨
    @Column(table = "BOARD_DETAIL_ID")
    private String content;
}
