package com.mini2S.branch.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Branch{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRANCH_SEQ")
    private Long branchSeq;

    @Column(columnDefinition = "varchar(50) not null unique comment '지점명'")
    private String branchName;

    @Column(columnDefinition = "varchar(255) comment '주소'")
    private String address;

    @Column(columnDefinition = "varchar(255) comment '상세주소'")
    private String addressDetail;

    @Column(columnDefinition = "decimal(20, 10) comment '좌표x'")
    private BigDecimal coordX;

    @Column(columnDefinition = "decimal(20, 10) comment '좌표y'")
    private BigDecimal coordY;

    @Column(columnDefinition = "varchar(100) comment '사용여부'")
    private String useYn;

}
