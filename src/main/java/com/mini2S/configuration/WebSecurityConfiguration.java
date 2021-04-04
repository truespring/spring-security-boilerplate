package com.mini2S.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .csrf().disable() // rest api이므로 csrf 보안이 필요없으므로 disable처리.
            .authorizeRequests()
                // 아래의 경로는 권한 허용
                .antMatchers("/*/signin", "/*/signin/**", "/*/signup", "/*/signup/**", "/social/**").permitAll()
                .antMatchers("/", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            .and()
//            .formLogin()
//                // 로그인 페이지도 권한 허용
//                .loginPage("/login")
//                .permitAll()
//            .and()
            .logout()
                .permitAll();
    }
    // Swagger 예외 처리
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**",
                "/swagger-ui.html", "/webjars/**", "/swagger/**");

    }




    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select userEmail, userPw "
                                    + "from users "
                                    + "where username =?")
                .authoritiesByUsernameQuery("select userEmail, userName "
                                    + "from user_role ur inner join user u on ur.user_id = u.id "
                                    + "inner join role r on ur.role_id = r.id "
                                    + "where email = ?");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

