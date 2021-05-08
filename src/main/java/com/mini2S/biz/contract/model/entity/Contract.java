package com.mini2S.biz.contract.model.entity;

import com.mini2S.biz.branch.model.entity.Branch;
import com.mini2S.biz.unit.model.entity.Unit;
import com.mini2S.biz.user.model.entity.Users;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTRACT_SEQ")
    private Long contractSeq;

    @OneToOne
    @JoinColumn(name = "USER_SEQ", nullable = false)
    private Users userSeq;

    @OneToOne
    @JoinColumn(name = "BRANCH_SEQ", nullable = false)
    private Branch branchSeq;

    @OneToOne
    @JoinColumn(name = "UNIT_SEQ", nullable = false)
    private Unit unitSeq;

    @Column(columnDefinition = "varchar(5) not null comment '계약 상태'")
    private String contractStatus;

    @Column(columnDefinition = "bigint comment '구매할 유닛 금액'")
    private Long priceUnit;

    @Column(columnDefinition = "bigint comment '유닛 상품 할인 금액'")
    private Long priceDiscountUnit;

    @Column(columnDefinition = "bigint comment '물품 금액'")
    private Long priceGoods;

    @Column(columnDefinition = "bigint comment '물품 할인 금액'")
    private Long priceDiscountGoods;

    @Column(columnDefinition = "bigint comment '기타 금액'")
    private Long priceETC;

    @Column(columnDefinition = "bigint comment '예치금, 보증금과 같은 개념'")
    private Long priceDeposit;

    @Column(columnDefinition = "bigint comment '총 결제 금액'")
    private Long priceTotal;

    @Column(columnDefinition = "bigint comment '미납 시 연체금'")
    private Long priceArrears;

    @Column(columnDefinition = "bigint comment '계약 종료 시 환불 및 추가 지급 금액'")
    private Long priceEnd;

    @Column(columnDefinition = "varchar(5) comment '사용개월, 정기계약 시 저장'")
    private String usageMonth;

    @Column(columnDefinition = "varchar(5) comment '사용일, 구독계약 시 저장'")
    private String usageDay;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP default '0000-00-00 00:00:00' comment '계약서 생성일'")
    private LocalDateTime createdDttm;

    @LastModifiedDate
    @Column(columnDefinition = "TIMESTAMP default '0000-00-00 00:00:00' comment '계약서 상태 변경일'")
    private LocalDateTime updateDttm;

    @Column(columnDefinition = "TIMESTAMP default '0000-00-00 00:00:00' comment '계약 확정 일자(예치금 결제 시)'")
    private LocalDateTime contractDttm;

    @Column(columnDefinition = "TIMESTAMP default '0000-00-00 00:00:00' comment '이용시작일자'")
    private LocalDateTime useStartDttm;

    @Column(columnDefinition = "TIMESTAMP default '0000-00-00 00:00:00' comment '이용종료일자'")
    private LocalDateTime useEndDttm;

    @Column(columnDefinition = "TIMESTAMP default '0000-00-00 00:00:00' comment '대금 미납 시 물품 처분일자'")
    private LocalDateTime disposalDttm;
}
