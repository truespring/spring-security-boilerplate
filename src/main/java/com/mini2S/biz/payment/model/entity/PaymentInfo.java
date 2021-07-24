package com.mini2S.biz.payment.model.entity;

import com.mini2S.common.user.model.entity.Users;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class PaymentInfo {
/*
// 실질적으로 결제(카드 or 계좌이체 등 결제 내역애 대한 내용)
 참고 사이트 : http://web.innopay.co.kr/dev_guide_web
SEQ	PK	FK	컬럼설명	컬럼명	데이터타입	길이	NULL	기본값	참조
1	O		결제정보ID	PAYMENT_INFO_ID	VARCHAR	100	X
2		O	이용자ID	USER_ID	VARCHAR	100	X		T_USER.USER_ID
3			결제타입	PAYMENT_TYPE	VARCHAR	100
5			상점ID	MID	VARCHAR	100
6			빌키	BILL_KEY	VARCHAR	100
7			카드번호	CARD_NUM	VARCHAR	16
8			카드유효기간	CARD_EXPIRE	INT	4
9			카드비밀번호(앞2자리)	CARD_PWD	VARCHAR	2
10			고유값	ID_NUM	VARCHAR	10    주민번호 앞자리/사업자등록번호 앞자리
11			상태	STATUS	CHAR	1
12			시작일시	START_DTTM	TIMESTAMP
13			종료일시	END_DTTM	TIMESTAMP
14			카드사코드	CARD_CODE	VARCHAR	100
15			카드사명	CARD_NAME	VARCHAR	100
16			결과로그	RESULT_LOG	MEDIUMTEXT

bank : 가상계좌
card : 카드결제

개인카드 : 생년월일6자리
법인카드 : 사업자번호

*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentInfoSeq;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private Users users;

    private String paymentType;

    private String mId;

    private String billKey;

    private String cardNum;

    private Long cardExpire;

    private String cardPwd;

    private String idNum;

    private Character status;

    private String cardCode;

    private String cardName;

    private String resultLog;
}
