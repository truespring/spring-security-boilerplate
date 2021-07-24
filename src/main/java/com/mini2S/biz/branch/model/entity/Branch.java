package com.mini2S.biz.branch.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "branch")
public class Branch{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_seq")
    private Long branchSeq;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "address")
    private String address;

    @Column(name = "address_detail")
    private String addressDetail;

    @Column(name = "coord_x")
    private String coordX;

    @Column(name = "coord_y")
    private String coordY;

    @Column(name = "use_yn")
    private String useYn;

}
