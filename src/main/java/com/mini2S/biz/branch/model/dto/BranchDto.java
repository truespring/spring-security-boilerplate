package com.mini2S.biz.branch.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
public class BranchDto {
    private String branchName;
    private String address;
    private String addressDetail;
    private String coordX;
    private String coordY;
    private String distanceFromUserToBranch;
    private List<String> branchImage;
}
