package com.mini2S.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NaverApiInfo {

    @Value("${naver.keyId}")
    static String keyId;

    @Value("${naver.keyId}")
    private void setKeyId(String keyId) {
        NaverApiInfo.keyId = keyId;
    }

    public String getKeyId() {
        return keyId;
    }

    @Value("${naver.key}")
    static String key;

    @Value("${naver.key}")
    private void setKey(String key) {
        NaverApiInfo.key = key;
    }

    public String getKey() {
        return key;
    }
}
