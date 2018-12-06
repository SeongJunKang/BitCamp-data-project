package bitcamp.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");

    // 1) 페이지 컨트롤러의 서블릿 경로를 알아낸다.
    String pageControllerPath = request.getServletPath().replace(".do", "");
    
    // 2) 페이지 컨트롤러를 찾는다.
    ServletContext servletContext = this.getServletContext();
    ApplicationContext applicationContext = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    Object pageController = applicationContext.getBean(pageControllerPath);
    
    try {
      // 3) 페이지 컨트롤러의 execute() 메서드를 호출한다.
      Method method = pageController.getClass().getMethod("execute", 
                            HttpServletRequest.class,
                            HttpServletResponse.class);
      String viewUrl = (String)method.invoke(pageController, request, response);
    
      // 4) 뷰 컴포넌트를 실행한다.
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
      } else {
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}










