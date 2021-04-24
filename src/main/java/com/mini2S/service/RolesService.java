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
    public Roles createNewRole(String roleName) {
        Roles role = rolesRepository.findByRoleName(roleName);
        List<String> roleNameList = rolesRepository.findAllRoleName();
        if(role == null || !roleNameList.contains(roleName)) {
            Roles newRole = new Roles();
            newRole.setRoleName(roleName);
            return rolesRepository.save(newRole);
        }
        return role;
    }
}
