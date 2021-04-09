package com.mini2S.service;

import com.mini2S.entity.roles.Roles;
import com.mini2S.reposotory.roles.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RolesService {
    private final RolesRepository rolesRepository;

    @Transactional
    public Roles save(Roles roles) {
        return rolesRepository.save(roles);
    }

    public Roles findRoleNameByRoleSeq(Long roleSeq) { return rolesRepository.findByRoleSeq(roleSeq); }

    public Roles findRoleSeqByRoleName(String roleName) { return rolesRepository.findByRoleName(roleName); }
}
