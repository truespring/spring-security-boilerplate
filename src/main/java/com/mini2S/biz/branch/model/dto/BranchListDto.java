package com.mini2S.biz.branch.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BranchListDto {

    private Long branchSeq;
    private String coordX;
    private String coordY;
    private String branchName;
    private String address;
    private String addressDetail;
}
