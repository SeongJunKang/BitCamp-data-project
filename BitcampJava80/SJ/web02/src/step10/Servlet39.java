// 서버에서 클라이언트로 쿠키 전달하기 - HTTP 응답 프로토콜과 쿠키
package step10;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step10/servlet39")
public class Servlet39 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String lastVisited = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("lastVisited")) {
        lastVisited = cookie.getValue();
        break;
      }
    }
    response.addCookie(new Cookie("lastVisited",
        new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())));
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>환영합니다.</h1>");
    out.printf("마지막 방문일 : %s\n",lastVisited);
    out.println("</body>");
    out.println("</html>");
  }
}
/*
#
-
 */
