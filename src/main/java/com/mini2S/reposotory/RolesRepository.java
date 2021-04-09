package com.mini2S.reposotory;

import com.mini2S.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    public Roles findByRoleName(String roleName);

    public Roles findByRoleSeq(Long roleSeq);

}
