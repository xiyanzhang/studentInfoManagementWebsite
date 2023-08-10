package com.example.interceptor;

import com.example.mapper.LogInStatusMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component
public class LogInInterceptor implements HandlerInterceptor {

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private LogInStatusMapper logInStatusMapper;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("已进入拦截器");

    response.setHeader("Access-Control-Allow-Origin","*");
    response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
    response.setHeader("Access-Control-Max-Age","3600");
    response.setHeader("Access-Control-Allow-Credentials","true");
    response.setHeader("Access-Control-Allow-Headers","*");

    if(request.getMethod().equals("OPTIONS")){
      return true;
    }

    String requestURI = request.getRequestURI();
    if (requestURI.contains("/checkAccountExistence")) {
      System.out.println("Log in page.");
      return true;
    }

    String token = request.getHeader("Token");
    System.out.println(token + " here");
    if (token != null) {
      boolean tokenValidity = checkTokenValidity(token);
      if (tokenValidity) {
        System.out.println("Token is valid");
        return true;
      }
      System.out.println("Token has expired");
      return false;
    }
    else {
      System.out.println("Token is missing. Authentication required.");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return false;
    }

  }

  public boolean checkTokenValidity(String token) throws JsonProcessingException {
    LocalDateTime expirationTime = logInStatusMapper.expirationTime(token);
    LocalDateTime currentTime = LocalDateTime.now();
    if (expirationTime.compareTo(currentTime) > 0) {
      return true;
    }
    return false;
  }
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    System.out.println("拦截器执行完毕");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
    System.out.println("得到返回结果：" + response);
    System.out.println("请求完毕");
  }
}
