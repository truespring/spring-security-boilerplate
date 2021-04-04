package com.mini2S.entity.roles;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleSeq;

    @Column(columnDefinition = "varchar(5) not null comment '권한 정보'")
    private String roleName;

    @Builder
    public Roles(Long roleSeq, String roleName) {
        this.roleSeq = roleSeq;
        this.roleName = roleName;
    }
}
