package com.mini2S.biz.contract.model.entity;

import com.mini2S.biz.branch.model.entity.Branch;
import com.mini2S.biz.unit.model.entity.Unit;
import com.mini2S.common.user.model.entity.Users;
import com.mini2S.model.entity.BaseTimeEntity;
import lombok.*;
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
    private Long contractSeq;

    @OneToOne
    private Users users;

    @OneToOne
    @JoinColumn(name = "branch_seq", nullable = false)
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "unit_seq", nullable = false)
    private Unit unit;

    private String contractStatus;

    private String contractQrImage;

    private Long priceUnit;

    private Long priceDiscountUnit;

    private Long priceGoods;

    private Long priceDiscountGoods;

    private Long priceEtc;

    private Long priceDeposit;

    private Long priceTotal;

    private Long priceArrears;

    private Long priceEnd;

    private String usageMonth;

    private String usageDay;

    @Column(name = "contract_dttm"
            ,insertable = false, updatable = false)
    private LocalDateTime contractDttm;

    private LocalDateTime useStartDttm;

    private LocalDateTime useEndDttm;

    @Column(name = "disposal_dttm"
            ,insertable = false, updatable = false)
    private LocalDateTime disposalDttm;

}
