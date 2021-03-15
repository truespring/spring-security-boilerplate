package com.rsupprot.board.service;

import com.rsupprot.board.entity.users.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersService {
    private UsersRepository usersRepository;

//    @Transactional
//    public long signin(UsersSigninDto dto){
////        Users users = usersRepository.findByUser_id(dto.getUser_id());
////        if(users != null){
//            return 1;
////        }else{
////            return 0;
////        }
//    }
}
