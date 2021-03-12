package com.rsupprot.board.controller;

import com.rsupprot.board.dto.PostsSaveRequestDto;
import com.rsupprot.board.webservice.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// autowired 대신에 사용함 : 추천
@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    //절대로 테이블과 매핑되는 Entity 클래스를 Request/ Response 클래스로 사용해서는 안됩니다.
    //Entity 클래스는 가장 Core한 클래스라고 보시면 되는데요.
    //View Layer와 DB Layer를 철저하게 역할 분리를 하는게 좋습니다.
    @GetMapping("/hello")
    public String hello(){
        return "helloworld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
