package com.mini2S.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_SEQ")
    private Long roleSeq;

    @Column(columnDefinition = "varchar(20) not null comment '권한 정보'")
    private String roleName;

    @OneToMany
    @JoinTable(name = "USER_ROLE", // 조인테이블명
            joinColumns = @JoinColumn(name = "ROLE_SEQ"), // 외래키
            inverseJoinColumns = @JoinColumn(name = "USER_SEQ")
    ) //반대 엔티티의 외래키
    private List<Users> user = new ArrayList<Users>();

    @Builder
    public Roles(Long roleSeq, String roleName) {
        this.roleSeq = roleSeq;
        this.roleName = roleName;
    }
}
