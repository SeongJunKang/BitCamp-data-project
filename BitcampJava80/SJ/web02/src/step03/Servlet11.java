// HttpServlet 클래스를 상속하여 HTTP 정보 추출하기
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step03/servlet11")
public class Servlet11 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();
    out.println("Servlet11");
    // HTTP 요청 헤더의 이름과 값 출력하기.
    Enumeration<String> names = httpreq.getHeaderNames();
    String name = null;
    while (names.hasMoreElements()) {
      name = names.nextElement();
      out.printf("%s = %s \n", name, httpreq.getHeader(name));
    }
  }
}


