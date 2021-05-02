package com.mini2S.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class RefreshToken implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOKEN_SEQ")
    private Long tokenSeq;

    @Column(name = "USER_EMAIL")
    private String userEmail;
    
    @Column(name = "REFRESH_TOKEN",
            columnDefinition = "varchar(500) not null comment '리프레시 토큰'")
    private String refreshToken;

}
