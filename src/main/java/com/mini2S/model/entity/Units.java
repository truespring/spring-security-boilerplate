package com.mini2S.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class Units {
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
16			기둥 깊이   COLUMDN_DEPTH	MEDIUMINT	9	X
17			기둥 부피   COLUMN_VOLUME DECIMAL	10,5	X
18			기둥 넓이   COLUMN_AREA	DECIMAL	10,5	X
19			실제 부피   ACTUAL_VOLUME DECIMAL	10,5	X
20			실제 넓이   ACTUAL_AREA	DECIMAL	10,5	X
21			평	       PY	        DECIMAL	4,2
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_SEQ")
    private Long roomSeq;

    @Column(columnDefinition = "varchar(100) not null comment '지점'")
    private String branchSeq;

    @Column(columnDefinition = "varchar(100) not null comment '상품'")
    private String productSeq;

    @Column(columnDefinition = "varchar(100) not null comment '룸코드'")
    private String roomCd;

    @Column(columnDefinition = "varchar(100) not null comment '룸명'")
    private String roomName;

    @Column(columnDefinition = "MEDIUMINT(10) not null comment '폭'")
    private Long sizeWidth;

    @Column(columnDefinition = "MEDIUMINT(10) not null comment '높이'")
    private Long sizeHeight;

    @Column(columnDefinition = "MEDIUMINT(10) not null comment '깊이'")
    private Long sizeDepth;

    @Column(columnDefinition = "varchar(10) not null comment '상태'")
    private String status;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '가격'")
    private Long price;

    @Column(columnDefinition = "varchar(400) comment '비고'")
    private String note;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '부피'")
    private BigDecimal sizeVolume;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '넓이'")
    private BigDecimal sizeArea;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '기둥 폭'")
    private Long columnWidth;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '기둥 높이'")
    private Long columnHeight;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '기둥 깊이'")
    private Long columnDepth;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '기둥 부피'")
    private BigDecimal columnVolume;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '기둥 넓이'")
    private BigDecimal columnArea;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '실제 부피'")
    private BigDecimal actualVolume;

    @Column(columnDefinition = "DECIMAL(10, 5) not null comment '실제 넓이'")
    private BigDecimal actualArea;

    @Column(columnDefinition = "DECIMAL(4, 2) comment '평'")
    private BigDecimal py;

}
