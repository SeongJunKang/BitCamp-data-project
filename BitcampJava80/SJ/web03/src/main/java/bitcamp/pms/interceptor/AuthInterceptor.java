package bitcamp.pms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response, 
      Object handler) throws Exception {
  HttpSession session = request.getSession();
  if (session.getAttribute("loginUser") == null) {
    response.sendRedirect(request.getContextPath()+"/auth/login.do");
    return false;
  }
    return true;
  }

}

/* 
# HandlerInterceptorAdaptor를 이용하여 스프링 인터셉터 만들기
- 이 클래스는 HandlerInterceptor 인터페이스를 미리 구현한 클래스이다.
- 이 클래스를 상속하면 개발자는 필요한 메서드만 오버라이드 할 수 있어 편리하다.

# "Callback" 
- 시스템이나 프로그램이 호출하는 메서드.

 */
