package com.mini2S.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImageEnum {
    // QR 코드 이미지 설정
    QRCODE_WIDTH(200),
    QRCODE_HEIGHT(200),
    QRCODE_COLOR(0xFF2e4e96),
    QRCODE_BG_COLOR(0xFFFFFFFF);

    private final Integer value;
}
