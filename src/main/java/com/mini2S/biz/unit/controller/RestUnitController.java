package com.mini2S.biz.unit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"4. Unit"})
@RequestMapping("/v1")
@RestController
@AllArgsConstructor
public class RestUnitController {

    @GetMapping("/unit/list")
    @ApiOperation(value = "지점에 해당하는 유닛 리스트 전달")
    public String unitList(String token, String branchId){
        return "";
    }
}
