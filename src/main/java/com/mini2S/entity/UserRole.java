package com.mini2S.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class UserRole implements Serializable {

    @Id
    @Column(name = "USER_SEQ")
    private long userSeq;

    @Id
    @Column(name = "ROLE_SEQ")
    private long roleSeq;
}
