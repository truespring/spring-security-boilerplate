package com.rsupprot.board.restAPI;

import com.rsupprot.board.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestUsersController {
    private UsersService usersService;

//    @PostMapping("/signin")
//    public int signin(@RequestBody UsersSigninDto dto){
//        usersService.signin(dto);
//        return 1;
//    }
}
