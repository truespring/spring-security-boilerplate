package com.rsupprot.board.restAPI;

import com.rsupprot.board.dto.PostsPatchRequestDto;
import com.rsupprot.board.dto.PostsSaveRequestDto;
import com.rsupprot.board.webservice.posts.PostsRepository;
import com.rsupprot.board.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

// autowired 대신에 사용함 : 추천
@RestController
@AllArgsConstructor
public class WebRestController {

    private final PostsRepository postsRepository;
    private final PostsService postsService;

    @PostMapping("/posts")
    public int savePosts(@RequestBody PostsSaveRequestDto dto){
        try{
            postsRepository.save(dto.toEntity());
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
    @PatchMapping("/posts")
    public int patchPosts(@RequestBody PostsPatchRequestDto dto){
        System.out.println(dto.getId());
        System.out.println(dto.getTitle());
        System.out.println(dto.getAuthor());
        System.out.println(dto.getContent());
        int chk = postsService.patch(dto);
        if(chk == 1){
            return 1;
        }else{
            return 0;
        }
    }
}
