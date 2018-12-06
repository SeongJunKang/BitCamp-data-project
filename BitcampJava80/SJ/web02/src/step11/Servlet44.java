// GET(로그인 폼 출력), POST(로그인 처리)
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/step11/main")
public class Servlet44 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    HttpSession session = request.getSession();
    Member member = (Member)session.getAttribute("loginUser");
    if (member == null) {
      response.sendRedirect("login"); // 로그인 폼을 다시 요청하라고 응답한다.
      return;
    }
    
    // 정상적으로 로그인한 사용자에게 출력하는 화면
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>메인화면</h1>");
    out.println("<div style='height:20px;background-color:yellow;'>");
    out.printf("%s(%s)<br>",member.getName(),member.getId());
    out.println("<a href='logout'>로그아웃</a><br>");
    out.println("<p>메인이다</p><br>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }
  
}
/*
#
-
 */
