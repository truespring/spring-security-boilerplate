package com.mini2S.biz.role.controller;

import com.mini2S.biz.role.model.entity.Roles;
import com.mini2S.biz.role.service.RolesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"2. Roles"})
@RequestMapping("/v1")
@RestController
@AllArgsConstructor
public class RestRoleController {
    private final RolesServiceImpl rolesServiceImpl;

    // 관리자 페이지 구축 시 권한 생성할 때 필요
    // 권한 정보
    @PostMapping("/roles/add")
    @ApiOperation(value = "권한 추가")
    public Roles addRoles(String roleName) {
       return rolesServiceImpl.createNewRole(roleName);
    }

}
