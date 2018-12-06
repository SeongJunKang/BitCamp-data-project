// 서버에서 클라이언트로 쿠키 전달하기 - HTTP 응답 프로토콜과 쿠키
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/step11/servlet41/page3")
public class Servlet41C extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // 세션보관소에 저장
    // request.getSession();이 리턴하는 객체는
    // Servlet41B에서 만든 세션 객체이다.
    // 왜? 요청 프로토콜에 세션 아이디가 쿠키 값으로 들어 있다.
    HttpSession session = request.getSession();
    session.setAttribute("email", request.getParameter("email"));
    session.setAttribute("tel", request.getParameter("tel"));
    
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>입력내용확인</h1>");
    out.println("<form action='page4' method='post'>");
    out.printf("이름 : %s<br>\n",session.getAttribute("name"));
    out.printf("나이 : %s<br>\n",session.getAttribute("age"));
    out.printf("전화 : %s<br>\n",session.getAttribute("tel"));
    out.printf("이메일 : %s<br>\n",session.getAttribute("email"));
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
