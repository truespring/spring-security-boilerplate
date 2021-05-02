package com.mini2S.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final UserDetailsService userDetailsService;

    // JWT accessToken 생성
    public String createAccessToken(String userPk, String role){
        // 토큰 유효시간 30분
        long tokenValidTime = 30 * 60 * 1000L;

        // JWT payload에 저장되는 PK값
        Claims claims = Jwts.claims().setSubject(userPk);
        claims.put("roles", role); // 정보는 key : value 쌍으로 저장

        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발생 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime)) // 토큰 만료 시간 저장
                .signWith(key) // 사용할 암호화알고리즘 + signature에 저장도리 secret값 세팅
                .compact();
    }
    // JWT refreshToken 생성
    public String createRefreshtoken(String value){
        // 1년
        long tokenValidTime = 365 * 24 * 60 * 60 * 1000L;
        Claims claims = Jwts.claims();
        claims.put("value", value);

        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(key)
                .compact();
    }

    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    // JWT 토큰에서 회원 정보 추출
    public String getUserPk(String token){
        return String.valueOf(Jwts.parserBuilder()
                            .setSigningKey(key)
                            .build()
                            .parseClaimsJws(token)
                            .getBody()
                            .getSubject());
    }

    // Request의 Header에서 token 값을 가져온다. "X-AUTH-TOKEN" : "TOKEN 값"
    public String resolveToken(HttpServletRequest request){
        return request.getHeader("X-AUTH-TOKEN");
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken){
        try{
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key)
                                .build().parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        }catch (Exception e){
            return false;
        }
    }
}



