package com.rsupprot.board.dto;

import com.rsupprot.board.entity.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSignupDto {
    private String userId;
    private String userName;
    private String userPw;
    private String userGender;
    private String userPhoneNumber;

    public Users toEntity(){
        return Users.builder()
                .userId(userId)
                .userName(userName)
                .userPw(userPw)
                .userGender(userGender)
                .userPhoneNumber(userPhoneNumber)
                .build();
    }
}
