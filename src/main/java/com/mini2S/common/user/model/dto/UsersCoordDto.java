package com.mini2S.common.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UsersCoordDto {

    private String coordX;
    private String coordY;
}
