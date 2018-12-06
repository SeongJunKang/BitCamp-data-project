// 서버에서 클라이언트로 쿠키 전달하기 - HTTP 응답 프로토콜과 쿠키
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step11/servlet40/page3")
public class Servlet40C extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>입력내용확인</h1>");
    out.println("<form action='page4' method='post'>");
    out.printf("이름 : %s<br>\n",request.getParameter("name"));
    out.printf("나이 : %s<br>\n",request.getParameter("age"));
    out.printf("전화 : %s<br>\n",request.getParameter("tel"));
    out.printf("이메일 : %s<br>\n",request.getParameter("email"));
    out.printf("<input type='hidden' name='name' value='%s'>\n"
        ,request.getParameter("name"));
    out.printf("<input type='hidden' name='age' value='%s'>\n"
        ,request.getParameter("age"));
    out.printf("<input type='hidden' name='tel' value='%s'>\n"
        ,request.getParameter("tel"));
    out.printf("<input type='hidden' name='email' value='%s'>\n"
        ,request.getParameter("email"));
    out.println("<button>입력 완료</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
/*
#
-
 */
