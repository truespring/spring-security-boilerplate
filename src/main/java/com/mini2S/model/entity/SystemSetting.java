package com.mini2S.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class SystemSetting {
/*
카카오 계정 고유값 등 STATIC 값 저장

SEQ	PK	FK	컬럼설명	컬럼명	데이터타입	길이	NULL
1	O		시스템설정ID	SYSTEM_SETTING_ID	VARCHAR	100	X
2			시스템설정코드	SETTING_CODE	VARCHAR	255	X
3			시스템설정값	SETTING_VALUE	VARCHAR	400

*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SYSTEM_SETTING_SEQ")
    private Long systemSettingSeq;

    @Column(columnDefinition = "varchar(255) not null comment '시스템설정코드'")
    private String settingCode;

    @Column(columnDefinition = "varchar(400) comment '시스템설정값'")
    private String settingValue;
}
