package com.rsupprot.board.restAPI;

import com.rsupprot.board.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestPageController {
    private final PostsService postsService;

    @GetMapping("/totalPage")
    public long totalPage(){
        return postsService.totalPageCount(10);
    }
}
