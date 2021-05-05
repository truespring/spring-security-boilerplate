package com.mini2S.branch.controller;

import com.mini2S.branch.model.dto.BranchDto;
import com.mini2S.branch.service.BranchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"3. Branch"})
@RequestMapping("/v1")
@RestController
@AllArgsConstructor
public class RestBranchController {
    private final BranchService branchService;

    @PostMapping("/branch/list/signin")
    @ApiOperation(value = "지점 목록(로그인)")
    public List<BranchDto> branchList(String token) {
        List<BranchDto> returnList = branchService.selectUserBranchList(token);
        return null;
    }

    @PostMapping("/branch/list/nonsignin")
    @ApiOperation(value = "지점 목록(비로그인)")
    public List<BranchDto> branchList() {
        List<BranchDto> returnList = branchService.selectBranchInfoList();
        return null;
    }
}
