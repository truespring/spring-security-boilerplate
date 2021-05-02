package com.mini2S.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSignupDto {
    private String userEmail;
    private String userName;
    private String userPw;
    private String userAccountType;
    private String userPhoneNumber;
}
