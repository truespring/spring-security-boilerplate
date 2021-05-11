package com.mini2S.model.entity;

import com.mini2S.common.role.model.entity.Roles;
import com.mini2S.common.user.model.entity.Users;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class UserRole implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "USER_SEQ")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "ROLE_SEQ")
    private Roles roles;
}
