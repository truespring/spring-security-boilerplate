package com.mini2S.model.entity;

public class Contracts {
    /*
UnitsPrice + User + Role = PK or FK 5개

SEQ	PK	FK	컬럼설명	컬럼명	데이터타입	길이	NULL	기본값	참조
1	O		계약ID	CONTRACT_ID	VARCHAR	100	X
2			상태  	STATUS	VARCHAR	10	X
3		O	사용자ID	USER_ID	VARCHAR	100	X		T_USER.USER_ID
4		O	관리자ID	MANAGER_ID	VARCHAR	100			T_USER.USER_ID
15		O	지점ID	BRANCH_ID	VARCHAR	100	X		T_BRANCH.BRANCH_ID
19		O	룸ID	ROOM_ID	VARCHAR	100	X		T_ROOM.ROOM_ID
72			계약일자	CONTRACT_DTTM	TIMESTAMP
22			이용시작일자	START_DTTM	TIMESTAMP
23			이용종료일자	END_DTTM	TIMESTAMP
81			처분일자	DISPOSAL_DTTM	TIMESTAMP
24			이용개월수	MONTH	INT	11
25			이용일수	DAY	INT	11
59			이용가격	PRICE_USAGE	INT	11
60			물품가격	PRICE_GOODS	INT	11
65			종료신청금액	PRICE_END	INT	11
61			예치금	DEPOSIT	INT	11
62			예치금VAT	DEPOSIT_VAT	INT	11
63			예치금상태	DEPOSIT_STATUS	VARCHAR	100
75			연체금	ARREARS	INT	11
66			기타금액	PRICE_ETC	INT	11
76			월별이용금액(+VAT)	PRICE_MONTH_USAGE_VAT	INT	11
77			월별물품금액(+VAT)	PRICE_MONTH_GOODS_VAT	INT	11		0
73			월이용금액(+VAT)	PRICE_MONTH_VAT	INT	11
67			총금액	PRICE_TOTAL	INT	11
68			총금액VAT	PRICE_TOTAL_VAT	INT	11
70			메모	NOTE	LONGTEXT



1 : 예약
10 : 이용신청서 작성
109 : 예약 (사용자페이지)
11 : 이용신청서작성 (결제완료)
119 : 예약 (결제완료) (사용자페이지)
12 : 예약 (연장)
129 : 연장예약완료 (사용자페이지(
2 : 이용중
20 : 정상이용중
209 : 이용중 (사용자페이지)
3 : 미납
30 :  미납
309 : 미납 (사용자페이지)
4 : 처분대상
40 : 처분대상
409 : 처분대상 (사용자페이지)
5 : 기타
50 : 기타
509 :  기타 (사용자페이지)
6 : 종료예정
60 : 종료예정
609 : 종료예정 (사용자페이지)
61 : 종료신청 (결제전)
619 : 종료신청 (결제전) (사용자페이지)
62 : 종료신청완료
629 : 종료신청완료 (사용자페이지)
7 : 종료
70 : 종료
709 : 종료 (사용자페이지)
71 : 처분종료
719 : 처분종료 (사용자페이지)

C : 법인
P : 개인
    */
}
