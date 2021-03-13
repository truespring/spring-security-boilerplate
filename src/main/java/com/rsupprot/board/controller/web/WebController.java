package com.rsupprot.board.controller.web;

import com.rsupprot.board.dto.PostsMainResponseDto;
import com.rsupprot.board.webservice.service.PostsService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@NoArgsConstructor
public class WebController {

    private PostsService postsService;

    // handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정됩니다.
    // (prefix: src/main/resources/templates, suffix: .hbs)
    @GetMapping("/")
    public String main(Model model) {
        List<PostsMainResponseDto> list = null;
        try {
            list = postsService.findAllDesc();
            System.out.println(list.get(0).getTitle());
            model.addAttribute("posts", list);
        }catch (Exception e){
            System.out.println("에러 발생");
            model.addAttribute("posts", list);
        }
        return "main";
    }
}
