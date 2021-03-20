package com.mini2S.board.entity.users;

import com.mini2S.board.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String userGender;

    @Column(nullable = false)
    private String userPhoneNumber;

    @Builder
    public Users(String userId, String userName, String userPw, String userGender, String userPhoneNumber){
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.userGender = userGender;
        this.userPhoneNumber = userPhoneNumber;
    }
}
