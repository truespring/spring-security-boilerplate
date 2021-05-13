package com.mini2S.biz.branch.controller;

import com.mini2S.biz.branch.model.dto.BranchDto;
import com.mini2S.biz.branch.service.BranchServiceImpl;
import com.mini2S.common.exception.CommonException;
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
    private final BranchServiceImpl branchService;

    /**
     *
     * @param token 사용자 토큰
     * @return 사용자 기반으로 한 지점 목록 거리순으로 정렬하여 반환
     */
    @PostMapping("/branch/list/signin")
    @ApiOperation(value = "지점 목록(로그인)")
    public List<BranchDto> branchList(String token) throws CommonException {
        return branchService.selectUserBranchList(token);
    }

    /**
     *
     * @return 기본 값을 기반으로 지점 목록 거리순으로 정렬하여 반환
     */
    @PostMapping("/branch/list/nonsignin")
    @ApiOperation(value = "지점 목록(비로그인)")
    public List<BranchDto> branchList() {
        return branchService.selectBranchInfoList();
    }
}
