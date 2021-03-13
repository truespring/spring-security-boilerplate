package com.rsupprot.board.webservice.service;

import com.rsupprot.board.dto.PostsSaveRequestDto;
import com.rsupprot.board.webservice.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    // DB 데이터를 등록/수정/삭제 하는 Service 메소드는 필수적
    // 즉, save 메소드를 통해서 10개 등록 중 5개 에러 -> 이전 것도 롤백
    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}
