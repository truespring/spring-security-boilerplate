package com.mini2S.configuration.security;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class RefreshToken implements Serializable {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "TOKEN_SEQ")
//    private Long tokenSeq;

    @Id
    @Column(name = "USER_EMAIL",
            columnDefinition = "varchar(50) not null comment '리프레시 토큰'")
    private String userEmail;
    
    @Column(name = "REFRESH_TOKEN",
            columnDefinition = "varchar(500) not null comment '리프레시 토큰'")
    private String refreshToken;

}
