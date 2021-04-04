package com.mini2S.restAPI;

import com.mini2S.dto.UsersSigninDto;
import com.mini2S.entity.users.Users;
import com.mini2S.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = {"1. Users"})
@RestController
@AllArgsConstructor
public class RestUsersController {
    private final UsersService usersService;

    // 로그인
    @PostMapping("/signin")
    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인")
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
    public long signup(@ApiParam(value = "ID(이메일)", required = true) @RequestParam String userEmail,
                       @ApiParam(value = "비밀번호", required = true) @RequestParam String userPw,
                       @ApiParam(value = "회원명", required = true) @RequestParam String userName,
                       @ApiParam(value = "가입경로", required = true) @RequestParam String userAccountType,
                       @ApiParam(value = "성별", required = true) @RequestParam String userGender,
                       @ApiParam(value = "휴대폰번호", required = true) @RequestParam String userPhoneNumber){
        System.out.println("도착");
        Users users = new Users();
        users.setUserEmail(userEmail);
        users.setUserName(userName);
        users.setUserAccountType(userAccountType);
        users.setUserPw(userPw);
        users.setUserGender(userGender);
        users.setUserPhoneNumber(userPhoneNumber);
        usersService.save(users);
        return 1;

    }


}
