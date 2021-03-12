package com.rsupprot.board.controller.web;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@NoArgsConstructor
public class WebController {

    // handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정됩니다.
    // (prefix: src/main/resources/templates, suffix: .hbs)
    @GetMapping("/")
    public String main(){
        return "main";
    }
}
