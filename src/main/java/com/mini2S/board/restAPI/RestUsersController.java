package com.mini2S.board.restAPI;

import com.mini2S.board.dto.UsersSigninDto;
import com.mini2S.board.dto.UsersSignupDto;
import com.mini2S.board.service.UsersService;
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
    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인")
    @PostMapping("/signin")
    public long signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String userId,
                       @ApiParam(value = "회원PW : 비밀번호", required = true) @RequestParam String userPw,
                       HttpServletRequest request){
        UsersSigninDto dto = new UsersSigninDto();
        dto.setUserId(userId);
        dto.setUserPw(userPw);
        long result = usersService.signin(dto);
        if(result == 1){
            HttpSession hs = request.getSession();
            hs.setAttribute("users", dto);
        }
        return result;
    }

    // 회원가입
    @PostMapping("/signup")
    public long signup(@ApiParam(value = "ID(이메일)", required = true) @RequestParam String userId,
                       @ApiParam(value = "비밀번호", required = true) @RequestParam String userPw,
                       @ApiParam(value = "회원명", required = true) @RequestParam String userName,
                       @ApiParam(value = "성별", required = true) @RequestParam String userGender,
                       @ApiParam(value = "휴대폰번호", required = true) @RequestParam String userPhoneNumber){
        UsersSignupDto dto = new UsersSignupDto();
        dto.setUserId(userId);
        dto.setUserName(userName);
        dto.setUserPw(userPw);
        dto.setUserGender(userGender);
        dto.setUserPhoneNumber(userPhoneNumber);
        return usersService.signup(dto);
    }


}
