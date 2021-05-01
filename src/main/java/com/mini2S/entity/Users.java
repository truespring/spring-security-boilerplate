package com.mini2S.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
//@Data getter, setter, RequiredArgsConstructor, ToString, EqualsAndHashCode 동시에
public class Users extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SEQ")
    private Long userSeq;

    @Column(columnDefinition = "varchar(50) not null unique comment '회원 이메일'")
    private String userEmail;

    @Column(columnDefinition = "varchar(100) not null comment '회원 비밀번호'")
    private String userPw;

    @Column(columnDefinition = "varchar(10) not null comment '회원 가입경로'")
    private String userAccountType;

    @Column(columnDefinition = "varchar(50) not null comment '회원 이름'")
    private String userName;

    @Column(columnDefinition = "varchar(30) not null comment '회원 전화번호'")
    private String userPhoneNumber;

    @Column(columnDefinition = "varchar(100) not null comment '회원 성별(M / W)'")
    private String userGender;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return "[PROTECTED]";
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
