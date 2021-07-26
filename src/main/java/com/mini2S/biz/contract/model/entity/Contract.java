package com.mini2S.biz.contract.model.entity;

import com.mini2S.biz.branch.model.entity.Branch;
import com.mini2S.biz.unit.model.entity.Unit;
import com.mini2S.common.user.model.entity.Users;
import com.mini2S.model.entity.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.Columns;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Builder
@Entity
public class Contract extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_seq")
    private Long contractSeq;

    @OneToOne
    @JoinColumn(name = "user_seq", nullable = false)
    private Users users;

    @OneToOne
    @JoinColumn(name = "branch_seq", nullable = false)
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "unit_seq", nullable = false)
    private Unit unit;

    @Column(name = "contract_status")
    private String contractStatus;

    @Column(name = "contract_qr_image")
    private String contractQrImage;

    @Column(name = "price_unit")
    private Long priceUnit;

    @Column(name = "price_discount_unit")
    private Long priceDiscountUnit;

    @Column(name = "price_goods")
    private Long priceGoods;

    @Column(name = "price_discount_goods")
    private Long priceDiscountGoods;

    @Column(name = "price_etc")
    private Long priceEtc;

    @Column(name = "price_deposit")
    private Long priceDeposit;

    @Column(name = "price_total")
    private Long priceTotal;

    @Column(name = "price_arrears")
    private Long priceArrears;

    @Column(name = "price_end")
    private Long priceEnd;

    @Column(name = "usage_month")
    private String usageMonth;

    @Column(name = "usage_day")
    private String usageDay;

    @Column(name = "contract_dttm"
            ,insertable = false, updatable = false)
    private LocalDateTime contractDttm;

    @Column(name = "use_start_dttm")
    private LocalDateTime useStartDttm;

    @Column(name = "use_end_dttm")
    private LocalDateTime useEndDttm;

    @Column(name = "disposal_dttm"
            ,insertable = false, updatable = false)
    private LocalDateTime disposalDttm;

}
