package com.mini2S.biz.branch.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class BranchDto {
    private final String branchName;
    private final String address;
    private final String addressDetail;
    private final String coordX;
    private final String coordY;
    private final Map<String, String> diffDistance;
    private final List<String> branchImage;
}
