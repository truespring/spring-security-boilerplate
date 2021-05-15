package com.mini2S.biz.unit.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UnitListDto {
    private Long unitSeq;
    private Long branchSeq;
    private Long unitProductSeq;
    private String unitName;
    private String unitRealWidth;
    private String unitRealHeight;
    private String unitRealDepth;
    private String unitStatus;
    private Long unitPrice;
    private String browserCoordX;
    private String browserCoordY;
    private String browserButtonWidth;
    private String browserButtonHeight;
}
