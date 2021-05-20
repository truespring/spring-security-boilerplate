package com.mini2S.common.user.service;

import com.mini2S.common.user.model.dto.UsersSigninDto;
import com.mini2S.common.user.model.dto.UsersSignupDto;
import com.mini2S.common.user.model.entity.Users;
import com.mini2S.configuration.security.TokenDto;
import com.mini2S.model.dto.TokenRequestDto;

public interface UsersService {
    TokenDto signIn(UsersSigninDto dto);

    Users signUpUser(UsersSignupDto dto);

    TokenDto reIssue(TokenRequestDto dto);
}
