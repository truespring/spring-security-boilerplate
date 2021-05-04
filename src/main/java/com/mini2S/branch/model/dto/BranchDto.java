package com.mini2S.branch.model.dto;

import com.mini2S.branch.model.entity.Branch;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
//@NoArgsConstructor
public class BranchDto {
    private Branch branch;
    private Double orderNum;
}
