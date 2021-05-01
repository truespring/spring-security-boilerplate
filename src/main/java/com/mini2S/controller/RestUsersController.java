package com.mini2S.controller;

import com.mini2S.configuration.security.JwtTokenProvider;
import com.mini2S.model.dto.UsersSigninDto;
import com.mini2S.model.dto.UsersSignupDto;
import com.mini2S.model.response.CommonResult;
import com.mini2S.service.ResponseService;
import com.mini2S.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = {"1. Users"})
@RestController
@AllArgsConstructor
public class RestUsersController {
    private final UsersService usersService;
    // 결과 반환 Service
    private final ResponseService responseService;

    private final JwtTokenProvider jwtTokenProvider;

    // 로그인
    @PostMapping("/signin")
    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인")
    public String signin(@RequestBody UsersSigninDto dto, HttpServletRequest request){
        String result = usersService.signin(dto);
        if(result != null){
            HttpSession hs = request.getSession();
            hs.setAttribute("users", dto);
        }
        return result;
    }

    // 회원가입
    @PostMapping("/signup")
    @ApiOperation(value = "회원가입", notes = "가입 경로 포함시켜야됨")
    public CommonResult signup(@RequestBody UsersSignupDto dto){
        usersService.signUpUser(dto);
        return responseService.getSuccessResult();
    }

    // 토큰 확인
    @GetMapping("/test")
    @ApiOperation(value = "토큰 확인")
    public String chk(String token) {
        String resultToken = jwtTokenProvider.getUserPk(token);
        System.out.print("resultToken : "+resultToken);
        return jwtTokenProvider.getUserPk(token);
    }

}
