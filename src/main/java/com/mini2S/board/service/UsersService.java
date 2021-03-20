package com.mini2S.board.service;

import com.mini2S.board.dto.UsersSigninDto;
import com.mini2S.board.dto.UsersSignupDto;
import com.mini2S.board.entity.users.Users;
import com.mini2S.board.entity.users.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Transactional
    public long signin(UsersSigninDto dto){
        Users users = usersRepository.findByUserId(dto.getUserId());
        // 유저 있음
        if(users != null && users.getUserId().equals(dto.getUserId())){
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
    @Transactional
    public long signup(UsersSignupDto dto){
        try{
            usersRepository.save(dto.toEntity());
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
