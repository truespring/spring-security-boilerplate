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
    @Column(name = "unit_seq")
    private Long unitSeq;

    @Column(name = "branch_seq")
    private Long branchSeq;

    @Column(name = "unit_status")
    private String unitStatus;

    @Column(name = "unit_product_seq")
    private Long unitProductSeq;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "unit_real_width")
    private String unitRealWidth;

    @Column(name = "unit_real_height")
    private String unitRealHeight;

    @Column(name = "unit_real_depth")
    private String unitRealDepth;
    
    // 브라우저 유닛 출력용
    @Column(name = "browser_coord_x")
    private String browserCoordX;

    @Column(name = "browser_coord_y")
    private String browserCoordY;

    @Column(name = "browser_button_width")
    private String browserButtonWidth;

    @Column(name = "browser_button_height")
    private String browserButtonHeight;
}
