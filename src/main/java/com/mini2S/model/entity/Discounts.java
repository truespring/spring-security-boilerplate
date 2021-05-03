package com.mini2S.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class Discounts {
    /*
SEQ	PK	FK	컬럼설명	    컬럼명	    데이터타입	길이	NULL	기본값	참조
1	O		할인ID	    DISCOUNT_ID	VARCHAR	100	X
2			할인명	    DC_TITLE	VARCHAR	100	X
3			할인율	    DC_RATE	    DECIMAL	5,1
4			할인금액	    DC_PRICE	MEDIUMTEXT
5			할인카테고리	DC_CATEGORY	VARCHAR	100	X
6			할인유형	    DC_TYPE	    VARCHAR	100
7			할인상한선	DC_LIMIT	INT	11
8			할인시작시점	DC_START_DTTM	TIMESTAMP
9			할인종료시점	DC_END_DTTM	TIMESTAMP
10		O	상품타입ID	PRODUCT_TYPE_ID	VARCHAR	100			T_PRODUCT_TYPE.PRODUCT_TYPE_ID
11		O	지점ID	    BRANCH_ID	VARCHAR	100			T_BRANCH.BRANCH_ID
12		O	룸ID	    ROOM_ID	    VARCHAR	100			T_ROOM.ROOM_ID
13		O	멤버십ID	    MEMBERSHIP_ID	VARCHAR	100			T_MEMBERSHIP.MEMBERSHIP_ID
14			기준월	    MONTH	    INT	11
15			메모	        DC_NOTE	    VARCHAR	255
16			할인상태	    DC_STATUS	VARCHAR	10
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISCOUNT_SEQ")
    private Long discountSeq;

    @Column(columnDefinition = "varchar(100) not null comment '할인명'")
    private String dcTitle;

    @Column(columnDefinition = "DECIMAL(5, 1) comment '할인율'")
    private Long dcRate;

    @Column(columnDefinition = "varchar(100) comment '할인금액'")
    private String dcPrice;

    @Column(columnDefinition = "varchar(100) not null comment '할인카테고리'")
    private String dcCategory;

    @Column(columnDefinition = "varchar(100) comment '할인유형'")
    private String dcType;

    @Column(columnDefinition = "INT(11) comment '할인상한선'")
    private Integer dcLimit;

    @Column(columnDefinition = "TIMESTAMP default '0000-00-00 00:00:00' comment '할인시작시점'")
    private LocalDateTime dcStartDttm;

    @Column(columnDefinition = "TIMESTAMP default '0000-00-00 00:00:00' comment '할인종료시점'")
    private LocalDateTime dcEndDttm;

    @Column(columnDefinition = "varchar(100) not null comment '상품타입'")
    private String productTypeSeq;

    @Column(columnDefinition = "varchar(100) not null comment '상품타입'")
    private String branchSeq;

    @Column(columnDefinition = "varchar(100) not null comment '방'")
    private String roomSeq;

    @Column(columnDefinition = "varchar(100) not null comment '멤버십'")
    private String membershipSeq;

    @Column(columnDefinition = "INT(11) not null comment '기준월'")
    private Integer month;

    @Column(columnDefinition = "varchar(255) comment '메모'")
    private String dcNote;

    @Column(columnDefinition = "varchar(10) comment '할인상태'")
    private String dcStatus;
}
