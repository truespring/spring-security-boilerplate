package com.mini2S.branch.model.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(columnDefinition = "varchar(100) comment '주소'")
    private String address;

    @Column(columnDefinition = "varchar(50) comment '상세주소'")
    private String addressDetail;

    @Column(columnDefinition = "varchar(100) comment '좌표x'")
    private String coordX;

    @Column(columnDefinition = "varchar(100) comment '좌표y'")
    private String coordY;

    @Column(columnDefinition = "varchar(5) comment '사용여부'")
    private String useYn;

}
