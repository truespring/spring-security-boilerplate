package com.mini2S.branch.service;

import com.mini2S.branch.model.dto.BranchDto;

import java.util.List;

public interface BranchService {
    List<BranchDto> selectBranchList(Long userSeq);
}
