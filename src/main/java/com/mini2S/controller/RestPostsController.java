package com.mini2S.controller;

import com.mini2S.model.dto.PostsPatchRequestDto;
import com.mini2S.model.dto.PostsSaveRequestDto;
import com.mini2S.biz.user.model.dto.UsersSigninDto;
import com.mini2S.configuration.reposotory.PostsRepository;
import com.mini2S.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// autowired 대신에 사용함 : 추천
@RestController
@AllArgsConstructor
public class RestPostsController {

    private final PostsRepository postsRepository;
    private final PostsService postsService;

    // 게시글 등록
    @PostMapping("/posts")
    public int savePosts(@RequestBody PostsSaveRequestDto dto, HttpServletRequest request){
        HttpSession hs = request.getSession();
        UsersSigninDto session = (UsersSigninDto) hs.getAttribute("users");
        dto.setAuthor(session.getUserEmail());
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
    // 게시글 수정 권한 체크
    @PostMapping("/postsChk")
    public int chkModifyAuth(@RequestBody PostsSaveRequestDto dto, HttpServletRequest request){
        HttpSession hs = request.getSession();
        UsersSigninDto session = (UsersSigninDto) hs.getAttribute("users");
        if(dto.getAuthor().equals(session.getUserEmail())){
            return 1;
        }else{
            return 0;
        }
    }
}
