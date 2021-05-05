package com.mini2S.common.controller;

import com.mini2S.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class WebController {

    private final PostsService postsService;

    // handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정됩니다.
    // (prefix: src/main/resources/templates, suffix: .hbs)
//    @GetMapping("/")
//    public String main(Model model, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        if(session.getAttribute("users") == null){
//            return "redirect:/login";
//        }else{
//        model.addAttribute("posts", postsService.findAllDesc(0, 10));
//        model.addAttribute("users", session.getAttribute("users"));
//        return "main";
//        }
//    }
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) throws IOException {
        // 1. 다른 파일들
        final DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("classpath:static/image/오목교점_메인.png");
        String path = resource.getFile().getAbsolutePath();
        System.out.println(path);
//        InputStream imageStream = new FileInputStream("http:"+path);
//        byte[] imageByteArr = IOUtils.toByteArray(imageStream);
//        model.addAttribute("img",path);
//        imageStream.close();
        // 2. 웹앱 경로
//        String imagePath = request.getServletContext().getRealPath("static/오목교점_메인.png");
//        System.out.println(imagePath);
//        InputStream imageStream = new FileInputStream("file:///"+imagePath);
//        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
//        imageStream.close();
//        model.addAttribute("img",imagePath);
        return "/login";
    }

//    @GetMapping("/logout")
//    public String logout(HttpSession session){
//        session.removeAttribute("users");
//        return "redirect:/login";
//    }
}
