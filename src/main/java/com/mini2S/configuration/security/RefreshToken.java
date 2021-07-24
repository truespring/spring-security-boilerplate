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
    private String userEmail;
    
    private String refreshToken;

}
