//리프레시 -HTML <meta>태그 이용.
package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step06/servlet29")
public class Servlet29 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
    
//    리다이렉트에서는 다음 출력이 의미 없다.
//    자세한 내용은 아래의 주석을 참고하라.
    resp.setContentType("text/HTML;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>refresh</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>리다이렉트 할 때 이 문장이 출력 될 까?</>");
    out.println("</body>");
    out.println("</html>");
    
    // 리다이렉트 명령을 내린다.
    resp.sendRedirect("http://www.google.com");
    
  }
}

/*
# Redirect
=> 버퍼에 출력된 내용이 있으면 버린다.
   왜? 리다이렉트는 클라이언트에게 콘텐츠를 보내지 않는다.
=> 응답 프로토콜 예 :
  HTTP/1.1 302 Found
  Server: Apache-Coyote/1.1
  Location: http://www.google.com
  Content-Type: text/HTML;charset=UTF-8
  Content-Length: 0
  Date: Thu, 12 May 2016 01:42:10 GMT

# Refresh vs Redirect
=> Refresh : 일정 시간 클라이언트에게 뭔가를 출력할 필요가 있을 때 사용한다.
=> Redirect : 중간에 출력하는 것 없이 바로 특정 URL로 보낼 때 사용한다.

 */
