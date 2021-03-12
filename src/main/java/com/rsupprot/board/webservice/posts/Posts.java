package com.rsupprot.board.webservice.posts;

import com.rsupprot.board.webservice.BaseTimeEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@NoArgsConstructor : 기본 생성자 자동 추가 , access = AccessLevel.PROTECTED : 기본생성자의 접근 권한을 protected로 제한
//@Entity
//테이블과 링크될 클래스임을 나타냅니다.
//언더스코어 네이밍(_)으로 이름을 매칭합니다.
//ex) SalesManager.java -> sales_manager table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    //해당 테이블의 PK 필드를 나타냅니다.
    //PK의 생성 규칙을 나타냅니다.
    //기본값은 AUTO 로, MySQL의 auto_increment와 같이 자동증가하는 정수형 값이 됩니다.
    //스프링 부트 2.0에선 옵션을 추가하셔야만 auto_increment가 됩니다!
    @Id
    @GeneratedValue
    private Long id;

    //테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됩니다.
    //사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용합니다.
    //문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: title), 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용됩니다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;

    //@Builder : 해당 클래스의 빌더패턴 클래스를 생성
    //생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
