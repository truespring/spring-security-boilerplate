package com.mini2S.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
public class BranchImage {
    /*
SEQ	PK	FK	컬럼설명	    컬럼명	        데이터타입	    길이	    NULL	기본값	참조	설명
1   O       지점사진 PK   BranchImage_Id    bigint
        O   지점 ID       branch_id
22 			지점 FK	    PIC01	          VARCHAR 	100			T_FILE.FILE_ID
            사진 순서      img_seq          varchar/bigint
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRANCH_IMAGE_SEQ")
    private Long branchImageSeq;

    @ManyToOne
    @JoinColumn(name = "BRANCH_SEQ")
    private Branch branch;

    @Column(columnDefinition = "varchar(100) comment '지점사진'")
    private String branchImage;

    @Column(columnDefinition = "bigint comment '지점순서'")
    private Long branchSort;
}
