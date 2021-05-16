package com.mini2S.biz.product.entity;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class UnitProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_PRODUCT_SEQ")
    private Long unitProductSeq;

    @Column(columnDefinition = "varchar(30) not null comment '유닛 상품 타입(큐브, 스몰, 미디움, 라지)'")
    private String unitProductType;

    @Column(columnDefinition = "varchar(30) not null comment '유닛 상품 타입(큐브, 스몰, 미디움, 라지)'")
    private String unitProductPrice;

}
