package com.mini2S.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class SessionConnect {
/*
SEQ	PK	FK	컬럼설명	컬럼명	데이터타입	길이	NULL	기본값	참조	설명
1	O		세션ID	SERVICE_SESSION_ID	VARCHAR	100	X
2	O		서버 ID	SERVER_ID	VARCHAR	100	X
3		O	사용자ID	USER_ID	VARCHAR	100	X		T_USER.USER_ID
4			LOGIN DATE	LOGIN_DATE	TIMESTAMP		X	'0000-00-00 00:00:00'
5			마지막 접속 시간	LAST_ACCESS_DATE	TIMESTAMP		X	'0000-00-00 00:00:00'
6			User Agent	USER_AGENT	VARCHAR	400
7			클라이언트 정보	CLIENT_INFO	VARCHAR	100
8			자동로그인여부	AUTO_LOGIN	VARCHAR	20				Y : 자동로그인 N : 일반로그인
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SERVICE_SESSION_SEQ")
    private Long serviceSessionSeq;

    @Column(columnDefinition = "varchar(100) not null comment '서버'")
    private String serverSeq;

    @Column(columnDefinition = "bigint not null comment '사용자'")
    private Long userSeq;

    @Column(columnDefinition = "varchar(400) comment 'UserAgent'")
    private String userAgent;

    @Column(columnDefinition = "varchar(100) comment '클라이언트 정보'")
    private String clientInfo;

    @Column(columnDefinition = "varchar(100) comment 'Y : 자동로그인 N : 일반로그인'")
    private String autoLogin;
}
