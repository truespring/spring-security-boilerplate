package com.mini2S.entity.roles;

import com.mini2S.entity.users.Users;
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

    //Users 테이블과 Join
//    @ManyToMany(mappedBy = "roles")
//    private List<Users> users = new ArrayList<>();

    @Builder
    public Roles(Long roleSeq, String roleName) {
        this.roleSeq = roleSeq;
        this.roleName = roleName;
    }
}
