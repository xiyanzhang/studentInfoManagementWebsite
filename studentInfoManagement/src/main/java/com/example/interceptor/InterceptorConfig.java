package com.example.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
  @Autowired
  LogInInterceptor LogInInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(LogInInterceptor).addPathPatterns("/**").excludePathPatterns("/**/checkAccountExistence");
  }
}

