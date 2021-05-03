package com.mini2S.branch.model.dto;

import com.mini2S.branch.model.entity.Branch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BranchDto {
    private Branch branch;
    private Double orderNum;
}
