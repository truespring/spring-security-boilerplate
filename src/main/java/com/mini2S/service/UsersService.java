package com.mini2S.service;

import com.mini2S.dto.UsersSigninDto;
import com.mini2S.entity.roles.Roles;
import com.mini2S.entity.users.Users;
import com.mini2S.reposotory.users.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

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
    public Users save(Users users){
        String encodePassword = passwordEncoder.encode(users.getUserPw());
        users.setUserPw(encodePassword);
        Roles roles = new Roles();
        roles.setRoleSeq(1L);
        users.getRoles().add(roles);
        return usersRepository.save(users);
    }
}
