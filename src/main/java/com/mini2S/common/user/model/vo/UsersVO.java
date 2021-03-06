package com.mini2S.common.user.model.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UsersVO {
    private Long userSeq;
    private String userEmail;
    private String userPw;
    private String userAccountType;
    private String userName;
    private String userPhoneNumber;
//    private String userGender;
    private String userAddress;
    private String userDetailAddress;
    private String coordX;
    private String coordY;
}
