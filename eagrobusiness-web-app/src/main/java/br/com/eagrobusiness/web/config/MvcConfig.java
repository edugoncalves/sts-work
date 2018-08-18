package br.com.eagrobusiness.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("classpath:/resources/"); 
        registry
        .addResourceHandler("/js/**")
        .addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**")
        .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/fonts/**")
        .addResourceLocations("classpath:/static/fonts/");
        registry.addResourceHandler("/img/**")
        .addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/skin/**")
        .addResourceLocations("classpath:/static/skin/");
        registry.addResourceHandler("/contactform/**")
        .addResourceLocations("classpath:/static/contactform/");
        
        
        
    }
}