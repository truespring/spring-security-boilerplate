package com.mini2S.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_SEQ")
    private Long goodsSeq;

    @Column(columnDefinition = "varchar(100) not null comment '물품명'")
    private String goodsName;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '폭'")
    private Long sizeWidth;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '높이'")
    private Long sizeHeight;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '깊이'")
    private Long sizeDepth;

    @Column(columnDefinition = "varchar(100) comment '물품이미지'")
    private String imgFileId;

    @Column(columnDefinition = "varchar(255) comment '비고'")
    private String note;

    @Column(columnDefinition = "varchar(10) not null comment '1 : 판매물품 2 : 렌탈물품 3 : 기타물품'")
    private String goodsType;

    @Column(columnDefinition = "varchar(10) not null comment 'Y : 사용 N : 미사용'")
    private String status;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '가격'")
    private Long price;

    @Column(columnDefinition = "integer(11) not null comment '수량'")
    private Integer amount;

    @CreatedDate
    private LocalDateTime insertDttm;
    /*
SEQ	PK	FK	컬럼설명	    컬럼명	    데이터타입	길이	NULL	기본값	참조	설명
1	O		물품ID	    GOODS_ID	VARCHAR	100	X
2			물품명	    GOODS_NAME	VARCHAR	100	X
3			넓이	        SiZE_WIDTH	MEDIUMINT	9	X
4			높이	        SIZE_HEIGHT	MEDIUMINT	9	X
5			깊이	        SIZE_DEPTH	MEDIUMINT	9	X
6		O	물품이미지	IMG_FILE_ID	VARCHAR	100			T_FILE.FILE_ID
7			비고	        NOTE	    VARCHAR	255
8			물품타입	    GOODS_TYPE	VARCHAR	10	X			1 : 판매물품 2 : 렌탈물품 3 : 기타물품
9			상태	        STATUS	    VARCHAR	10	X			Y : 사용 N : 미사용
10			가격	        PRICE	    MEDIUMINT	9	X
11			등록일	    INSERT_DTTM	TIMESTAMP		X	'CURRENT_TIMESTAMP'
12			수량	        AMOUNT	    INT	11
    */
}
