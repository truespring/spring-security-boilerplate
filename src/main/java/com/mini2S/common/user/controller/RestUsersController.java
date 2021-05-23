package com.mini2S.common.user.controller;

import com.mini2S.common.user.model.entity.Users;
import com.mini2S.configuration.security.JwtTokenProvider;
import com.mini2S.configuration.security.TokenDto;
import com.mini2S.model.dto.TokenRequestDto;
import com.mini2S.common.user.model.dto.UsersSigninDto;
import com.mini2S.common.user.model.dto.UsersSignupDto;
import com.mini2S.model.response.SingleResult;
import com.mini2S.service.ResponseService;
import com.mini2S.common.user.service.UsersServiceImpl;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1. Users"})
@RequestMapping("/v1")
@RestController
@AllArgsConstructor
public class RestUsersController {
    private final UsersServiceImpl usersServiceImpl;
    // 결과 반환 Service
    private final ResponseService responseService;

    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 로그인
     *
     * @param usersSigninDto 로그인을 위한 dto
     * @return 로그인 정보
     */
    @PostMapping("/user/signin")
    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인")
    @ApiImplicitParam(
            name = "usersSigninDto",
            value = "사용자 로그인 \n\n" +
                    "[필수 항목] \n\n " +
                    "userEmail : 사용자 이메일 \n" +
                    "userPw : 사용자 암호",
            required = true,
            paramType = "body",
            dataType = "UsersSigninDto")
    public SingleResult<TokenDto> signin(@RequestBody UsersSigninDto usersSigninDto) {
        return responseService.getSingleResult(usersServiceImpl.signIn(usersSigninDto));
    }

    /**
     * 회원가입
     *
     * @param usersSignupDto 회원가입을 위한 dto
     * @return 회원가입 정보
     */
    @PostMapping("/user/signup")
    @ApiOperation(value = "회원가입", notes = "가입 경로 포함시켜야됨")
    @ApiImplicitParam(
            name = "usersSignupDto",
            value = "사용자 회원가입 \n\n" +
                    "[필수 항목] \n\n " +
                    "address : 사용자 주소 \n" +
                    "addressDetail : 사용자 상세 주소 \n\n" +
                    "userAccountType : 사용자 회원가입 경로(카카오, 네이버 등) \n\n" +
                    "userEmail : 사용자 이메일 \n" +
                    "userName : 사용자 이름 \n" +
                    "userPhoneNumber : 사용자 휴대번호 \n\n" +
                    "userPw : 사용자 암호",
            required = true,
            paramType = "body",
            dataType = "UsersSignupDto")
    public SingleResult<Users> signup(@RequestBody UsersSignupDto usersSignupDto) {
        return responseService.getSingleResult(usersServiceImpl.signUpUser(usersSignupDto));
    }

    /**
     * 토큰 확인
     *
     * @param accessToken 로그인 시 발급되는 access 토큰
     * @return 사용자 토큰 발급(access, refresh 토큰)
     */
    @GetMapping("/user/test")
    @ApiOperation(value = "토큰 확인")
    @ApiImplicitParam(
            name = "accessToken",
            value = "사용자가 로그인 시 발급 받은 accessToken",
            required = true,
            paramType = "query",
            dataType = "String")
    public String chk(String accessToken) {
        return jwtTokenProvider.getUserPk(accessToken);
    }

    /**
     * 토큰 갱신
     *
     * @param tokenRequestDto access 토큰
     * @return refresh 토큰 발급
     */
    @PostMapping("/user/reissue")
    @ApiOperation(value = "토큰 갱신")
    @ApiImplicitParam(
            name = "tokenRequestDto",
            value = "사용자 토큰 갱신 \n\n" +
                    "[필수 항목] \n\n " +
                    "accessToken : 사용자 accessToken \n" +
                    "refreshToken : 사용자 refreshToken",
            required = true,
            paramType = "body",
            dataType = "TokenRequestDto")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(usersServiceImpl.reIssue(tokenRequestDto));
    }

}
