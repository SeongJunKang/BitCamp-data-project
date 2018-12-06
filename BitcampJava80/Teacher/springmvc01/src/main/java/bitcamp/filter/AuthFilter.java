package bitcamp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("*")
public class AuthFilter implements Filter{

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // ServletRequest에는 세션을 꺼내는 메서드(getSession())이 없다.
    // 따라서 원래의 타입으로 형변환 한 뒤에 사용해야 한다.
    HttpServletRequest request2 = (HttpServletRequest) request;
    
    // ServletResponse에는 sendRedirect() 메서드가 없기 때문에
    // 원래의 타입으로 형변환 한 뒤에 사용해야 한다.
    HttpServletResponse response2 = (HttpServletResponse) response;
    
    String servletPath = request2.getServletPath();
    if (!servletPath.startsWith("/controller31/")) { // 로그인 요청이 아니라면,
      // 무조건 로그인 되었는지 검사해야 한다.
      HttpSession session = request2.getSession();
      if (session.getAttribute("userInfo") == null) {
        response2.sendRedirect(request2.getContextPath() + "/controller31/login.do");
        return;
      }
    }
    
    // 로그인 되었거나 로그인 요청에 대해서는 통과시킨다.
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {}

}

/*
# 로그인 여부 검사하기
- 필터를 사용하지 않으면 모든 서블릿에  
  로그인 여부를 검사하는 코드를 삽입해야 한다. 

*/