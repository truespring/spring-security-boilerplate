package com.mini2S.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class Files {
    /*
    SEQ	PK	FK	컬럼설명	컬럼명	데이터타입	길이	NULL	기본값	참조
    1	O		파일ID	FILE_ID	VARCHAR	100	X
    3			원파일명	ORG_FILE_NAME	VARCHAR	255	X
    4			저장파일명	SAVE_FILE_NAME	VARCHAR	255	X
    5			저장디렉토리	SAVE_DIR	VARCHAR	255	X
    6			확장자	FILE_EXT	VARCHAR	100
    7			콘텐츠타입	CONTENT_TYPE	VARCHAR	100	X
    8			파일크기	FILE_SIZE	DECIMAL	20	X
    9		O	업로드사용자ID	USER_ID	VARCHAR	100			T_USER.USER_ID
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_SEQ")
    private Long fileSeq;

    @Column(columnDefinition = "varchar(255) not null comment '원파일명'")
    private String orgFileName;

    @Column(columnDefinition = "varchar(255) not null comment '저장파일명'")
    private String saveFileName;

    @Column(columnDefinition = "varchar(255) not null comment '저장경록'")
    private String saveDir;

    @Column(columnDefinition = "varchar(10) comment '확장자'")
    private String fileExt;

    @Column(columnDefinition = "varchar(100) not null comment '콘텐츠타입'")
    private String contentType;

    @Column(columnDefinition = "decimal(20) not null comment '저장파일명'")
    private BigDecimal fileSize;

    @Column(columnDefinition = "varchar(100) comment '저장파일명'")
    private String userSeq;
}
