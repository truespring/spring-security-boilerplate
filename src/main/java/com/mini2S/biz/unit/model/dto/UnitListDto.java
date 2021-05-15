package com.mini2S.biz.unit.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnitListDto {
    private final Long unitSeq;
    private final Long branchSeq;
    private final String unitProductSeq;
    private final String unitName;
    private final String unitRealWidth;
    private final String unitRealHeight;
    private final String unitRealDepth;
    private final String unitStatus;
    private final Long unitPrice;
    private final String browserCoordX;
    private final String browserCoordY;
    private final String browserButtonWidth;
    private final String browserButtonHeight;
}
