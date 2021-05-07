package com.mini2S.biz.branch.model.dto;

import com.mini2S.biz.branch.model.entity.Branch;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
//@NoArgsConstructor
public class BranchDto {
    private String branchName;
    private String address;
    private String addressDetail;
    private String coordX;
    private String coordY;
    private String useYn;
    private Long branchImageSort;
    private String branchImage;
}
