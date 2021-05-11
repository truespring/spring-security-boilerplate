package com.mini2S.common.user.model.dto;

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
