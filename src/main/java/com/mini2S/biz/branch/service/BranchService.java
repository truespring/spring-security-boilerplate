package com.mini2S.biz.branch.service;

import com.mini2S.biz.branch.model.dto.BranchDto;

import java.util.List;

public interface BranchService {
    List<BranchDto> selectUserBranchList(String token);

    List<BranchDto> selectBranchInfoList();

    List<BranchDto> selectBranchInfoListTest();
}
