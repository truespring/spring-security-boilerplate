package com.mini2S.biz.unit.model.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_SEQ")
    private Long unitSeq;

    @Column(columnDefinition = "bigint not null comment '지점ID'")
    private Long branchSeq;

    @Column(columnDefinition = "bigint not null comment '상품ID, 슬림, 큐브인지 등등'")
    private Long unitProductSeq;

    @Column(columnDefinition = "varchar(100) not null comment '룸명'")
    private String unitName;

    @Column(columnDefinition = "varchar(10) not null comment '유닛 실제 너비'")
    private String unitRealWidth;

    @Column(columnDefinition = "varchar(10) not null comment '유닛 실제 높이'")
    private String unitRealHeight;

    @Column(columnDefinition = "varchar(10) not null comment '유닛 실제 깊이'")
    private String unitRealDepth;

    @Column(columnDefinition = "varchar(5) not null comment '사용 가능 여부, 공실 상태'")
    private String unitStatus;

    @Column(columnDefinition = "bigint not null comment '가격'")
    private Long unitPrice;

    // 브라우저 유닛 출력용
    @Column(columnDefinition = "varchar(100) not null comment '브라우저 축척 X좌표'")
    private String browserCoordX;

    @Column(columnDefinition = "varchar(100) not null comment '브라우저 축척 Y좌표'")
    private String browserCoordY;

    @Column(columnDefinition = "varchar(10) not null comment '브라우저 출력 유닛 css width'")
    private String browserButtonWidth;

    @Column(columnDefinition = "varchar(10) not null comment '브라우저 출력 유닛 css height'")
    private String browserButtonHeight;
}
