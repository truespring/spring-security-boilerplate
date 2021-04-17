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
public class GoodsContracts {
    /*
SEQ	PK	FK	컬럼설명	컬럼명	데이터타입	길이	NULL	기본값	참조	설명
1	O		물품계약ID	GOODS_CONT_ID	VARCHAR	100	X
2		O	계약ID	CONTRACT_ID	VARCHAR	100			T_CONTRACT.CONTRACT_ID
3		O	상담ID	COUNSEL_ID	VARCHAR	100			T_COUNSEL.COUNSEL_ID
4		O	물품ID	GOODS_ID	VARCHAR	100	X		T_GOODS.GOODS_ID
5			물품수량	AMOUNT	INT	11		0
6			물품가격	PRICE	INT	11
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_CONT_SEQ")
    private Long goodsContSeq;

    @Column(columnDefinition = "bigint comment '계약'")
    private Long contractSeq;

    @Column(columnDefinition = "bigint comment '상담'")
    private Long counselSeq;

    @Column(columnDefinition = "bigint comment '물품'")
    private Long goodsSeq;

    @Column(columnDefinition = "MEDIUMINT(9) not null comment '가격'")
    private Long price;

    @Column(columnDefinition = "integer(11) not null comment '수량'")
    private Integer amount;
}
