/* 주제: JavaEE에서 제공하는 HttpServlet 클래스 상속하기 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet14")
public class Servlet14 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // 서블릿 컨테이너
  //   --> service(ServletRequest, ServletResponse)  <== Servlet 인터페이스
  //         --> service(HttpServletRequest, HttpServletResponse) <== HttpServlet 클래스
  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    //=> http://localhost:8080/web02/step04/servlet14
    out.printf("getRequestURL() => %s\n", request.getRequestURL().toString());

    //=> /web02/step04/servlet14
    out.printf("getRequestURI() => %s\n", request.getRequestURI());
    
    //=> /step04/servlet14
    out.printf("getServletPath() => %s\n", request.getServletPath());

    //=> name=okok&email=okok@test.com&tel=111-1111
    out.printf("getQueryString() => %s\n", request.getQueryString());
    
    //=> okok
    out.printf("getParameter(\"name\") => %s\n", request.getParameter("name"));
  }
}

/*
# 

 */

















