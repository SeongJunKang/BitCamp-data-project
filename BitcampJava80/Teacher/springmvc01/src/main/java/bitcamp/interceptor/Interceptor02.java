package bitcamp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor02 extends HandlerInterceptorAdapter {
  @Override
  public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
    System.out.println("preHandle()");
    return true;
  }

}

/*
# HandlerInterceptorAdapter를 이용하여 스프링 인터셉터 만들기
- 이 클래스는 HandlerInterceptor 인터페이스를 미리 구현한 클래스이다.
- 이 클래스를 상속하면 개발자는 필요한 메서드만 오버라이드 할 수 있어 편리하다.
*/









