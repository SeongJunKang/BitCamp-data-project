package bitcamp.pms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    // 1) 페이지 컨트롤러의 서블릿 경로를 알아낸다.
    String pageControllerPath = request.getServletPath().replace(".do", "");
    
    // 2) 요청 배달자를 준비한다.
    RequestDispatcher rd = request.getRequestDispatcher(pageControllerPath);
    
    response.setContentType("text/html;charset=UTF-8");
    
    // 3) 페이지 컨트롤러를 실행한다.
    rd.include(request, response);
    
    // 4) 뷰 컴포넌트의 URL을 알아낸다.
    String viewUrl = (String)request.getAttribute("view");
    
    // 5) 뷰 컴포넌트를 실행한다.
    if (viewUrl.startsWith("redirect:")) {
      response.sendRedirect(viewUrl.substring(9));
    } else {
      rd = request.getRequestDispatcher(viewUrl);
      rd.include(request, response);
    }
  }
}










