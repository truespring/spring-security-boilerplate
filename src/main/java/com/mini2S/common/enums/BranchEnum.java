package com.mini2S.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BranchEnum {
    /*
    1 : 예약 (일반)
    5 : 이용신청서 작성 (결제 전)
    10 : 이용신청서 작성 (결제 후)
    20 : 정상이용중
    30 : 예약 (연장)
    40 : 미납
    50 : 종료예정
    51 : 종료신청 (결제전)
    52 : 종료완료 (결제후)
    */
    DEFAULT_X("37.49645524999698"),
    DEFAULT_Y("127.03274326109371");

    private final String value;
}
