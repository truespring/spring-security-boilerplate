package com.mini2S.biz.branch.model.dto;

import com.mini2S.biz.branch.model.entity.Branch;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
//@NoArgsConstructor
public class BranchDto {
    private Branch branch;
    private Double orderNum;
    private String imagePath;
}
