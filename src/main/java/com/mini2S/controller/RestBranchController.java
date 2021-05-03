package com.mini2S.controller;

import com.mini2S.entity.Branch;
import com.mini2S.service.BranchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"3. Branch"})
@RestController
@AllArgsConstructor
public class RestBranchController {
    private final BranchService branchService;

    @PostMapping("/branch/list")
    @ApiOperation(value = "지점 목록")
    public List<Branch> branchList(Long userSeq) {
        return branchService.findBranchList(userSeq);
    }
}