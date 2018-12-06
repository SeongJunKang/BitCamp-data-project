package bitcamp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor02 extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(
      HttpServletRequest request, 
      HttpServletResponse response,
      Object handler) throws Exception {
    System.out.println("prehanlder");
    return true;
  }

}

