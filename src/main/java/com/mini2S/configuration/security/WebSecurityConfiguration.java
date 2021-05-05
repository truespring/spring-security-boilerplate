package com.mini2S.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .httpBasic().disable()
            .csrf().disable() // rest api이므로 csrf 보안이 필요없으므로 disable처리.
            // 토큰 기반이므로 세션 사용 안함
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests()
                    // 아래의 경로는 권한 허용
                    .antMatchers("/*/signin", "/*/signin/**", "/signup", "/signin", "/*/signup", "/*/signup/**", "/social/**", "/test", "/reissue").permitAll()
                    .antMatchers("/css/**", "/js/**", "/image/**", "/login").permitAll()
                    .anyRequest().authenticated()
            .and()
            .formLogin()
                // 로그인 페이지도 권한 허용
                .loginPage("/login")
                .permitAll()
            .and()
            .logout()
                .permitAll()
            .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider)
                                , UsernamePasswordAuthenticationFilter.class)
            ;
    }
    // Swagger 예외 처리
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**",
                "/swagger-ui.html", "/webjars/**", "/swagger/**", "/swagger-ui.html#!/**");

    }
}

