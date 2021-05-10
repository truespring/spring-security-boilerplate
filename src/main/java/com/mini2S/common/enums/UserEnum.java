package com.mini2S.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEnum {
    M("남자"),
    F("여자");

    private final String value;
}
