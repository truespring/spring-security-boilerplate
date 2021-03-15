package com.rsupprot.board.restAPI;

import com.rsupprot.board.dto.PostsPatchRequestDto;
import com.rsupprot.board.dto.PostsSaveRequestDto;
import com.rsupprot.board.entity.posts.PostsRepository;
import com.rsupprot.board.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

// autowired 대신에 사용함 : 추천
@RestController
@AllArgsConstructor
public class RestPostsController {

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
    // 게시글 수정
    @PatchMapping("/posts")
    public int patchPosts(@RequestBody PostsPatchRequestDto dto){
        int chk = postsService.patch(dto);
        if(chk == 1){
            return 1;
        }else{
            return 0;
        }
    }
    // 게시글 삭제
    @DeleteMapping("/posts")
    public int deletePosts(@RequestBody PostsPatchRequestDto dto){
        try{
            postsRepository.deleteById(dto.getId());
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
