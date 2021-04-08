package com.mini2S.restAPI;

import com.mini2S.entity.roles.Roles;
import com.mini2S.model.response.CommonResult;
import com.mini2S.service.ResponseService;
import com.mini2S.service.RolesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"2. Roles"})
@RestController
@AllArgsConstructor
public class RestRoleController {
    private RolesService rolesService;

    // 권한 정보
    @PostMapping("/addRoles")
    @ApiOperation(value = "권한 추가")
    public Roles addRoles(String roleName) {
        Roles roles = new Roles();
        roles.setRoleName(roleName);
        return rolesService.save(roles);
    }
}
