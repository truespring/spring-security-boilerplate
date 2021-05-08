package com.mini2S.biz.branch.model.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BranchVO {
    private Long branchSeq;
    private String branchName;
    private String address;
    private String addressDetail;
    private String coordX;
    private String coordY;
    private String useYn;
    private Long branchImageSort;
    private String branchImage;
    private Long branchSort;
}
