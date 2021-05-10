package com.mini2S.common.enums;

public enum RoleEnum {
    ROLENAME("USER_ROLE");

    public String roleName;

    RoleEnum(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return this.roleName;
    }
}
