package com.rsupprot.board.webservice.service;

import com.rsupprot.board.dto.PostsMainResponseDto;
import com.rsupprot.board.dto.PostsSaveRequestDto;
import com.rsupprot.board.dto.PostsPatchRequestDto;
import com.rsupprot.board.webservice.posts.Posts;
import com.rsupprot.board.webservice.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    // DB 데이터를 등록/수정/삭제 하는 Service 메소드는 필수적
    // 즉, save 메소드를 통해서 10개 등록 중 5개 에러 -> 이전 것도 롤백
    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc(PageRequest.of(0,10))
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public int patch(PostsPatchRequestDto dto){
        Optional<Posts> list = postsRepository.findById(dto.getId());
        // 만약 list가 있다면
        if(list.isPresent()){
            postsRepository.save(dto.toEntity());
            return 1;
        }
        return 0;
    }
}
