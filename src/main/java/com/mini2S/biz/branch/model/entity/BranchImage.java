package com.mini2S.biz.branch.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "branch_image")
public class BranchImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_image_seq")
    private Long branchImageSeq;

    @ManyToOne
    @JoinColumn(name = "branch_seq")
    private Branch branch;

    @Column(name = "branch_image")
    private String branchImage;

    @Column(name = "branch_image_sort")
    private Long branchImageSort;
}
