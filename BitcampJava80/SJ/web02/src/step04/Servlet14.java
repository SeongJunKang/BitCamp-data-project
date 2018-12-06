//  HTTP 응답 헤더 추가하기 - HTTP 응답 프로토콜 분석
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

//  서블릿 컨테이너
//    --> service(ServletRequest, ServletResponse) <==Servlet 인터페이스
//        --> service(HttpServletRequest,HttpServletResponse) <== HttpServlet 클래스
  
  private static final long serialVersionUID = 1L;
  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();
    out.println("Servlet14");
    
    //=>  http://localhost:8080/web02/step04/servlet14
    out.printf("getRequestURL() => %s\n",httpreq.getRequestURL().toString());
    //=> web02/step04/servlet14
    out.printf("getRequestURI() => %s\n",httpreq.getRequestURI());
    //=> /step04/servlet14
    out.printf("getServletPath() => %s\n",httpreq.getServletPath());
    //=> name=aaaa&email=bbbb
    out.printf("getQueryString() => %s\n",httpreq.getQueryString());
    //=> aaaa
    out.printf("getQueryString() => %s\n",httpreq.getParameter("name"));
  }
}

