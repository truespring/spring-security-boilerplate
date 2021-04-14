package com.mini2S.service;

import com.mini2S.entity.Roles;
import com.mini2S.reposotory.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<String> findAllRoleName() {return rolesRepository.findAllRoleName(); }
}
