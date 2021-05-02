package com.mini2S.configuration.security;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenDto {
    private final String accessToken;
    private final String refreshToken;
}
