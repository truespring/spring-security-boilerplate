package com.mini2S.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/image/**")
                // 절대 경로
//            .addResourceLocations("file:///D:/2_Develop/2021 Project/board/build/resources/main/static/image/");
                // 상대 경로
            .addResourceLocations("file:src/main/resources/static/image/");
    }
}
