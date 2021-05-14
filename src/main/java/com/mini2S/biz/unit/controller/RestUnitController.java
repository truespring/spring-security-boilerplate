package com.mini2S.biz.unit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"4. Unit"})
@RequestMapping("/v1")
@RestController
@AllArgsConstructor
public class RestUnitController {

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "X-AUTH-TOKEN",
                    value = "로그인 성공 후 AccessToken",
                    required = true,
                    dataType = "String",
                    paramType = "header"
            )
    })
    @GetMapping("/unit/list")
    @ApiOperation(value = "지점에 해당하는 유닛 리스트 전달")
    public String unitList(String branchId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println("이메일 : "+email);
        System.out.println("지점 아이디 : "+branchId);
        return "";
    }
}
