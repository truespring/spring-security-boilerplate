package com.rsupprot.board.restAPI;

import com.rsupprot.board.dto.UsersSigninDto;
import com.rsupprot.board.dto.UsersSignupDto;
import com.rsupprot.board.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@AllArgsConstructor
public class RestUsersController {
    private final UsersService usersService;

    // 로그인
    @PostMapping("/signin")
    public long signin(@RequestBody UsersSigninDto dto, HttpServletRequest request){
        long result = usersService.signin(dto);
        if(result == 1){
            HttpSession hs = request.getSession();
            hs.setAttribute("users", dto);
        }
        return result;
    }

    // 회원가입
    @PostMapping("/signup")
    public long signup(@RequestBody UsersSignupDto dto){
        return usersService.signup(dto);
    }


}
