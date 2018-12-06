package bitcamp.interceptor;

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
    if (session.getAttribute("userInfo") == null) {
      response.sendRedirect(request.getContextPath() + "/controller31/login.do");
      return false;
    }
    
    return true;
  }

}










