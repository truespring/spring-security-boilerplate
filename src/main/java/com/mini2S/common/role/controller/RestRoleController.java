package com.mini2S.common.role.controller;

import com.mini2S.common.role.model.entity.Roles;
import com.mini2S.common.role.service.RolesServiceImpl;
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

    /**
     * 새로운 권한을 추가한다
     *
     * @param roleName 새로운 권한 이름
     * @return 새로운 권한 추가
     */
    @PostMapping("/roles/add")
    @ApiOperation(value = "권한 추가")
    public Roles addRoles(String roleName) {
        return rolesServiceImpl.createNewRole(roleName);
    }

}
