package com.mini2S.service;

import com.mini2S.model.dto.PostsMainResponseDto;
import com.mini2S.model.dto.PostsPatchRequestDto;
import com.mini2S.model.dto.PostsSaveRequestDto;
import com.mini2S.entity.Posts;
import com.mini2S.reposotory.PostsRepository;
import com.mini2S.common.util.Paging;
import lombok.AllArgsConstructor;
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
    public long totalPageCount(int size){
        return Paging.calculatePageCount(postsRepository.count(), size);
    }


    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc(int page, int printListSize) {
        return postsRepository.findAllDesc(PageRequest.of(page, printListSize))
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public int patch(PostsPatchRequestDto dto){
        Optional<Posts> list = postsRepository.findById(dto.getId());
        // 만약 list가 있다면
        if(list.isPresent()){
            Posts posts = list.get();
            posts.setId(dto.getId());
            posts.setTitle(dto.getTitle());
            posts.setAuthor(dto.getAuthor());
            posts.setContent(dto.getContent());
            postsRepository.save(posts);
            return 1;
        }
        return 0;
    }
}
