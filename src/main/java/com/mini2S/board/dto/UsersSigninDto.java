package com.mini2S.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSigninDto {

    private Long id;
    private String userId;
    private String userName;
    private String userPw;
    private String userGender;
    private String userPhoneNumber;
}
