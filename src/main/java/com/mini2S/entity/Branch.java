package com.mini2S.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Branch{
    /*
SEQ	PK	FK	컬럼설명	컬럼명	    데이터타입	길이	NULL	기본값	참조	설명
1	O		지점ID	BRANCH_ID	VARCHAR	    100	X
2			지점명	BRANCH_NAME	VARCHAR	    100	X
5			주소	    ADDRESS1	VARCHAR	    255
6			상세주소	ADDRESS2	VARCHAR	    255
7			좌표x	COORD_X	    DECIMAL	    20,10
8			좌표y	COORD_Y	    DECIMAL	    20,10
12			사용여부	USE_YN	    MEDIUMINT	9				Y : 활성, N : 비활성 . 지점 폐쇄 여부
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRANCH_SEQ")
    private Long branchSeq;

    @Column(columnDefinition = "varchar(50) not null unique comment '지점명'")
    private String branchName;

    @Column(columnDefinition = "varchar(255) comment '주소'")
    private String address;

    @Column(columnDefinition = "varchar(255) comment '상세주소'")
    private String addressDetail;

    @Column(columnDefinition = "decimal(20) comment '좌표x'")
    private Double coordX;

    @Column(columnDefinition = "decimal(20) comment '좌표y'")
    private Double coordY;

    @Column(columnDefinition = "varchar(100) comment '사용여부'")
    private String useYn;

}
