package com.mini2S.biz.unit.model.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitSeq;

    private Long branchSeq;

    private String unitStatus;

    private Long unitProductSeq;

    private String unitName;

    private String unitRealWidth;

    private String unitRealHeight;

    private String unitRealDepth;
    
    // 브라우저 유닛 출력용
    private String browserCoordX;

    private String browserCoordY;

    private String browserButtonWidth;

    private String browserButtonHeight;
}
