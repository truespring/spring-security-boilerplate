package com.mini2S.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Long roomId;

//    @Column(columnDefinition = "varchar(50) not null comment '지점ID'")
//    private String branchId;

    @Column(columnDefinition = "varchar(100) not null comment '상품ID'")
    private String productId;

    @Column(columnDefinition = "varchar(100) not null comment '룸코드'")
    private String roomCd;

    @Column(columnDefinition = "varchar(100) not null comment '룸명'")
    private String roomName;

    @Column(columnDefinition = "MEDIUMINT(10) not null comment '폭'")
    private String sizeWidth;

    @Column(columnDefinition = "MEDIUMINT(10) not null comment '높이'")
    private String sizeHeight;

    @Column(columnDefinition = "MEDIUMINT(10) not null comment '깊이'")
    private String sizeDepth;

    @Column(columnDefinition = "varchar(10) not null comment '상태'")
    private String status;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '가격'")
    private String price;

    @Column(columnDefinition = "varchar(400) not null comment '비고'")
    private String note;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '부피'")
    private String sizeVolume;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '넓이'")
    private String sizeArea;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '기둥 폭'")
    private String columnWidth;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '기둥 높이'")
    private String columnHeight;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '기둥 깊이'")
    private String columnDepth;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '기둥 부피'")
    private String columnVolume;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '기둥 넓이'")
    private String columnArea;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '실제 부피'")
    private String actualVolume;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '실제 넓이'")
    private String actualArea;

    @Column(columnDefinition = "DECIMAL(4, 2) not null comment '평'")
    private String py;

    /*
SEQ	PK	FK	컬럼설명	   컬럼명	    데이터타입	길이	NULL
1	O		룸ID	  ROOM_ID	    VARCHAR	100	X
2		O	지점ID	  BRANCH_ID	    VARCHAR	100	X
3		O	상품ID	  PRODUCT_ID	VARCHAR	100	X
4			룸코드	  ROOM_CD	    VARCHAR	100	X
5			룸명	      ROOM_NAME	    VARCHAR	100	X
6			폭	      SIZE_WIDTH	MEDIUMINT	10	X
7			높이	      SIZE_HEIGHT	MEDIUMINT	10	X
8			깊이	      SIZE_DEPTH	MEDIUMINT	10	X
9			상태	      STATUS	    VARCHAR	10	X
10			가격       PRICE	        MEDIUMINT	9	X
11			비고       NOTE	        VARCHAR	400
12			부피	      SIZE_VOLUME	DECIMAL	10,5	X
13			넓이	      SIZE_AREA	    DECIMAL	10,5	X
14			기둥 폭	  COLUMN_WIDTH	MEDIUMINT	9	X
15			기둥 높이   COLUMN_HEIGHT MEDIUMINT	9	X
16			기둥 깊이   COLUMN_DEPTH	MEDIUMINT	9	X
17			기둥 부피   COLUMN_VOLUME DECIMAL	10,5	X
18			기둥 넓이   COLUMN_AREA	DECIMAL	10,5	X
19			실제 부피   ACTUAL_VOLUME DECIMAL	10,5	X
20			실제 넓이   ACTUAL_AREA	DECIMAL	10,5	X
21			평	       PY	        DECIMAL	4,2
    */
}
