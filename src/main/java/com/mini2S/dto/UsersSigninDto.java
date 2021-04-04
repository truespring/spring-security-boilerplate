package com.mini2S.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSigninDto {

    private Long userSeq;
    private String userEmail;
    private String userName;
    private String userPw;
    private String userGender;
    private String userPhoneNumber;
}
