package com.mini2S.dto;

import com.mini2S.entity.Users;
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
    private String userGender;
    private String userPhoneNumber;

    public Users toEntity(){
        return Users.builder()
                .userEmail(userEmail)
                .userName(userName)
                .userPw(userPw)
                .userAccountType(userAccountType)
                .userGender(userGender)
                .userPhoneNumber(userPhoneNumber)
                .build();
    }
}
