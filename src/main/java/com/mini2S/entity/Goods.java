package com.mini2S.entity;

public class Goods {
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
