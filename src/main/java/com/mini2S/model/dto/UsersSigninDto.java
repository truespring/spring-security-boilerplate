package com.mini2S.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSigninDto {

    private String userEmail;
    private String userPw;
}
