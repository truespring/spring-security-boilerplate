package com.mini2S.model.dto;

import com.mini2S.entity.Branch;
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
