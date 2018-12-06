// 서버에서 클라이언트로 쿠키 전달하기 - HTTP 응답 프로토콜과 쿠키
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step11/servlet40/page4")
public class Servlet40D extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>입력결과</h1>");
    out.println("<p>다음 정보들 [<br>");
    out.printf("이름 : %s<br>\n",request.getParameter("name"));
    out.printf("나이 : %s<br>\n",request.getParameter("age"));
    out.printf("전화 : %s<br>\n",request.getParameter("tel"));
    out.printf("이메일 : %s<br>\n",request.getParameter("email"));
    out.println("]을 저장하였습니다.</p>");
    out.println("</body>");
    out.println("</html>");
  }
}
/*
#
-
 */
