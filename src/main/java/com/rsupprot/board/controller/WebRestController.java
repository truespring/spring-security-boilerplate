package com.rsupprot.board.controller;

import com.rsupprot.board.dto.PostsSaveRequestDto;
import com.rsupprot.board.webservice.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// autowired 대신에 사용함 : 추천
@RestController
@AllArgsConstructor
public class WebRestController {

    private final PostsRepository postsRepository;

    @PostMapping("/posts")
    public int savePosts(@RequestBody PostsSaveRequestDto dto){
        try{
            postsRepository.save(dto.toEntity());
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
