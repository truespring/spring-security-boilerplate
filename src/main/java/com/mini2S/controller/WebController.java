package com.mini2S.controller;

import com.mini2S.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class WebController {

    private final PostsService postsService;

    // handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정됩니다.
    // (prefix: src/main/resources/templates, suffix: .hbs)
    @GetMapping("/")
    public String main(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
//        if(session.getAttribute("users") == null){
//            return "redirect:/login";
//        }else{
        model.addAttribute("posts", postsService.findAllDesc(0, 10));
        model.addAttribute("users", session.getAttribute("users"));
        return "main";
//        }
    }
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("users");
        return "redirect:/login";
    }
}
