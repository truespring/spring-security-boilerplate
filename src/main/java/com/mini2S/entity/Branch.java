package com.mini2S.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class Branch extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRANCH_ID")
    private Long branchId;

    @Column(columnDefinition = "varchar(50) not null unique comment '지점명'")
    private String branchName;

    @Column(columnDefinition = "varchar(16) not null comment '우편번호'")
    private String zipCode;

    @Column(columnDefinition = "varchar(255) not null comment '주소'")
    private String address;

    @Column(columnDefinition = "varchar(255) not null comment '상세주소'")
    private String addressDetail;

    @Column(columnDefinition = "varchar(100) not null comment '시도'")
    private String sido;

    @Column(columnDefinition = "varchar(100) not null comment '시군구'")
    private String sigungu;

    @Column(columnDefinition = "varchar(100) not null comment '법정동/법정리'")
    private String bName;

    @Column(columnDefinition = "decimal(20) not null comment '좌표x'")
    private BigDecimal coordX;

    @Column(columnDefinition = "decimal(20) not null comment '좌표y'")
    private BigDecimal coordY;

    @Column(columnDefinition = "varchar(100) not null comment '사용여부'")
    private String useYn;

    @CreatedDate
    private LocalDateTime openDt;
    /*
SEQ	PK	FK	컬럼설명	컬럼명	    데이터타입	길이	NULL	기본값	참조	설명
1	O		지점ID	BRANCH_ID	VARCHAR	    100	X
2			지점명	BRANCH_NAME	VARCHAR	    100	X
4			우편번호	ZIPCODE	    VARCHAR	    16
5			주소	    ADDRESS1	VARCHAR	    255
6			상세주소	ADDRESS2	VARCHAR	    255
15			시도	    SIDO	VARCHAR	100
16			시군구	SIGUNGU	VARCHAR	100
17			법정동/법정리	BNAME	VARCHAR	100
7			좌표x	COORD_X	    DECIMAL	    20,10
8			좌표y	COORD_Y	    DECIMAL	    20,10
12			사용여부	USE_YN	    MEDIUMINT	9				Y : 활성, N : 비활성 . 지점 폐쇄 여부
13			오픈일	OPEN_DT	    TIMESTAMP			'0000-00-00 00:00:00'

    * */
}
