package com.mini2S.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenRequestDto {
    private final String accessToken;
    private final String refreshToken;
}
