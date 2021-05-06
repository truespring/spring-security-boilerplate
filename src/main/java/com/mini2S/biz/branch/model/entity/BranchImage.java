package com.mini2S.biz.branch.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class BranchImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRANCH_IMAGE_SEQ")
    private Long branchImageSeq;

    @ManyToOne
    @JoinColumn(name = "BRANCH_SEQ")
    private Branch branch;

    @Column(columnDefinition = "varchar(255) comment '지점 사진'")
    private String branchImage;

    @Column(columnDefinition = "bigint comment '지점 사진 순서'")
    private Long branchImageSort;
}
