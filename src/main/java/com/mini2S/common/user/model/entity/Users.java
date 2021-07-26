package com.mini2S.common.user.model.entity;

import com.mini2S.model.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Builder
@Entity
//@Data getter, setter, RequiredArgsConstructor, ToString, EqualsAndHashCode 동시에
public class Users extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long userSeq;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_account_type")
    private String userAccountType;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_phone_number")
    private String userPhoneNumber;

    @Column(name = "uesr_address")
    private String userAddress;

    @Column(name = "user_detail_address")
    private String userDetailAddress;

    @Column(name = "coord_x")
    private String coordX;

    @Column(name = "coord_y")
    private String coordY;

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
