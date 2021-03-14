package com.rsupprot.board.dto;

import com.rsupprot.board.webservice.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
public class PostsPatchRequestDto {
    private Long id;
    private String title;
    private String author;
    private String content;

    @Builder
    public PostsPatchRequestDto(Long id, String title, String author, String content){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
