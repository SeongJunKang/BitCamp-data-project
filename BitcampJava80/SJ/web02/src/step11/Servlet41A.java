// 서버에서 클라이언트로 쿠키 전달하기 - HTTP 응답 프로토콜과 쿠키
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step11/servlet41/page1")
public class Servlet41A extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>기본정보</h1>");
    out.println("<form action='page2' method='post'>");
    out.println("이름 : <input type='text' name='name'><br>");
    out.println("나이 : <input type='text' name='age'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
/*
#
-
 */
