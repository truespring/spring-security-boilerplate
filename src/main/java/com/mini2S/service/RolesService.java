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
        Roles role = rolesRepository.findByRoleName(roleName); // 해당 권한 이름이 있는지 조회
        List<String> roleNameList = rolesRepository.findAllRoleName(); // 권한 이름 전부 조회
        if(role == null || !roleNameList.contains(roleName)) {
            Roles newRole = new Roles();
            newRole.setRoleName(roleName);
            return rolesRepository.save(newRole); // 새로운 권한 생성
        }
        return role;
    }
}
