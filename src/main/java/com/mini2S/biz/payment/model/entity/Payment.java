package com.mini2S.biz.payment.model.entity;

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
public class Payment {
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
    private Long paymentSeq;

    private Long paymentInfoSeq;

    private Long contractSeq;

    private String paymentType;

    private String moId;

    private String paymentStatus;

    private Long paymentAmount;

    private String tid;

    private String paymentMethod;

    private String resultCode;

    private String resultMsg;

    private String mId;

    private LocalDateTime paymentAttemptDttm;

    private LocalDateTime paymentCompleteDttm;
}
