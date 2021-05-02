package com.mini2S.controller;

import com.mini2S.entity.Roles;
import com.mini2S.service.RolesService;
import com.mini2S.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"2. Roles"})
@RestController
@AllArgsConstructor
public class RestRoleController {
    private final RolesService rolesService;

    private final UsersService usersService;

    // 권한 정보
    @PostMapping("/roles/add")
    @ApiOperation(value = "권한 추가")
    public Roles addRoles(String roleName) {
       return rolesService.createNewRole(roleName);
    }

}
