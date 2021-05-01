package com.mini2S.service;

import com.mini2S.configuration.security.JwtTokenProvider;
import com.mini2S.entity.UserRole;
import com.mini2S.model.dto.UsersSigninDto;
import com.mini2S.entity.Roles;
import com.mini2S.entity.Users;
import com.mini2S.model.dto.UsersSignupDto;
import com.mini2S.reposotory.RolesRepository;
import com.mini2S.reposotory.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UsersService {
    private final long roleSeq = 1L;
    private final String roleName = "USER_ROLE";
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String signin(UsersSigninDto dto){
        Users users = usersRepository.findByUserEmailOrderByUserSeq(dto.getUserEmail());
        // 유저 있음
        if(users != null && users.getUserEmail().equals(dto.getUserEmail())){
            if(passwordEncoder.matches(dto.getUserPw(), users.getUserPw())){
                //로그인 성공
                String roleName = rolesRepository.findRoleNameByUserSeq(users.getUserSeq());
                return jwtTokenProvider.createToken(users.getUserEmail(), roleName);
//                return "성공"
            }else{
                //패스워드 틀림
                return null;
            }
        // 유저 없음
        }else{
            return null;
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
    public void signUpUser(UsersSignupDto dto){
        Users chkUser = usersRepository.findByUserEmailOrderByUserSeq(dto.getUserEmail());
        if (chkUser != null || chkUser.getUserEmail() != null) {
            // 회원가입 아이디 중복 부분
        }

        String encodePassword = passwordEncoder.encode(dto.getUserPw());
        Roles roles = rolesRepository.findByRoleSeq(roleSeq); // 회원가입시 최초 권한 조회
        if(roles == null || !roles.getRoleName().equals(roleName)) {
            Roles role = null;
            role.setRoleName(roleName);
            rolesRepository.save(role); // 최초 권한 없으면 새로 만들어줌
            roles = rolesRepository.findByRoleSeq(roleSeq);
        }
        usersRepository.save(Users.builder()
                            .userEmail(dto.getUserEmail())
                            .userName(dto.getUserName())
                            .userAccountType(dto.getUserAccountType())
                            .userPw(encodePassword)
                            .userGender(dto.getUserGender())
                            .userPhoneNumber(dto.getUserPhoneNumber())
                            .build()); // 회원가입
        Users user = usersRepository.findByUserEmailOrderByUserSeq(dto.getUserEmail());
        rolesRepository.insertUserRole(user.getUserSeq(), roles.getRoleSeq()); // 가입한 사용자에게 권한 부여
    }
}
