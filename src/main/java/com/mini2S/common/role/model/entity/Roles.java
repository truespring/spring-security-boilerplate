package com.mini2S.common.role.model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_SEQ")
    private Long roleSeq;

    @Column(columnDefinition = "varchar(20) not null comment '권한 정보'")
    private String roleName;
}
