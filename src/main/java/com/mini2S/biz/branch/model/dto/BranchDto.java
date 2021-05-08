package com.mini2S.biz.branch.model.dto;

import com.mini2S.biz.branch.model.entity.Branch;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
//@NoArgsConstructor
public class BranchDto {
    private String branchName;
    private String address;
    private String addressDetail;
    private String coordX;
    private String coordY;
    private List<String> branchImage;
}
