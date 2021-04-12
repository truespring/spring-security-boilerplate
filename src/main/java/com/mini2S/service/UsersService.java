package com.mini2S.service;

import com.mini2S.dto.UsersSigninDto;
import com.mini2S.entity.Roles;
import com.mini2S.entity.Users;
import com.mini2S.reposotory.RolesRepository;
import com.mini2S.reposotory.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UsersService {
    private final long roleSeq = 1L;
    private final String roleName = "USER_ROLE";

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final RolesRepository rolesRepository;


    @Transactional
    public long signin(UsersSigninDto dto){
        Users users = usersRepository.findByUserEmail(dto.getUserEmail());
        // 유저 있음
        if(users != null && users.getUserEmail().equals(dto.getUserEmail())){
            if(users.getUserPw().equals(dto.getUserPw())){
                //로그인 성공
                return 1;
            }else{
                //패스워드 틀림
                return 2;
            }
        // 유저 없음
        }else{
            return 0;
        }
    }
//    @Transactional
//    public long signup(UsersSignupDto dto){
//        String encodePassword = passwordEncoder.encode(dto.getUserPw());
//        dto.setUserPw(encodePassword);
//        try{
//            usersRepository.save(dto.toEntity());
//            return 1;
//        }catch (Exception e){
//            return 0;
//        }
//    }
    @Transactional
    public void signUpUser(Users users){
        String encodePassword = passwordEncoder.encode(users.getUserPw());
        users.setUserPw(encodePassword);
        Roles roles = null;
        roles = rolesRepository.findByRoleSeq(roleSeq); // 회원가입시 최초 권한 조회
        if(roles == null || !roles.getRoleName().equals(roleName)) {
            Roles addRole = null;
//            addRole.setRoleSeq(roleSeq);
            addRole.setRoleName(roleName);
            rolesRepository.save(addRole); // 최초 권한 없으면 새로 만들어줌
            roles = rolesRepository.findByRoleSeq(roleSeq);
        }
        usersRepository.save(users);
        Users selUser = usersRepository.findByUserEmail(users.getUserEmail());
        rolesRepository.insertUserRole(selUser.getUserSeq(), roles.getRoleSeq());
//        return selUser;
    }
}
