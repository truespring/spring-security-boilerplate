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
public class Payments {
    /*
    PK	FK	컬럼설명	컬럼명	데이터타입	길이	NULL
1	O		결제ID	PAYMENT_ID	VARCHAR	100	X
2			주문번호	MOID	VARCHAR	100
3		O	결제정보ID	PAYMENT_INFO_ID	VARCHAR	100
4			결제타입	PAYMENT_TYPE	VARCHAR	100
5		O	계약ID	CONTRACT_ID	VARCHAR	100	X
8			결제상태	STATUS	VARCHAR	20
9			금액	AMT	INT	11
10			TID	TID	VARCHAR	100
12			시작일	START_DATE	DATE
13			종료일	END_DATE	DATE
14			결제일시	PAYMENT_DTTM	TIMESTAMP
15			결제완료일시	PAID_DTTM	VARCHAR	100
16			등록일	INSERT_DTTM	TIMESTAMP
17			결제수단	PAYMENT_METHOD	VARCHAR	100
18			결과코드	RESULT_CODE	VARCHAR	100
19			결과메세지	RESULT_MSG	VARCHAR	100
20			업데이트일시	UPDATE_DTTM	TIMESTAMP
21			상점ID	MID	VARCHAR	100
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_SEQ")
    private Long paymentSeq;

    @Column(columnDefinition = "varchar(100) comment '주문번호'")
    private String moId;

    @Column(columnDefinition = "bigint comment '결제정보'")
    private Long paymentInfoSeq;

    @Column(columnDefinition = "varchar(100) comment '결제타입'")
    private String paymentType;

    @Column(columnDefinition = "bigint comment '계약'")
    private Long contractSeq;

    @Column(columnDefinition = "varchar(20) comment '결제상태'")
    private String status;

    @Column(columnDefinition = "bigint comment '금액'")
    private Long amt;

    @Column(columnDefinition = "varchar(100) comment 'TID'")
    private String tid;

    @Column(columnDefinition = "varchar(100) comment '결제수단'")
    private String paymentMethod;

    @Column(columnDefinition = "varchar(100) comment '결과코드'")
    private String resultCode;

    @Column(columnDefinition = "varchar(100) comment '결과메세지'")
    private String resultMsg;

    @Column(columnDefinition = "varchar(100) comment '상점'")
    private String mId;
}
