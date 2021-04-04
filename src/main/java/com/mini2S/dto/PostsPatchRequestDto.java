package com.mini2S.dto;

import com.mini2S.entity.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostsPatchRequestDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime modifiedDate;

    @Builder
    public PostsPatchRequestDto(Long id, String title, String author, String content, LocalDateTime modifiedDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.modifiedDate = modifiedDate;
    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
