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
    @Column(name = "unit_product_seq")
    private Long unitProductSeq;

    @Column(name = "unit_product_type")
    private String unitProductType;

    @Column(name = "unit_product_price")
    private String unitProductPrice;

}
