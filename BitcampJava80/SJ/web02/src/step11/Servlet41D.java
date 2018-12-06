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

@WebServlet("/step11/servlet41/page4")
public class Servlet41D extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // 요청 프로토콜의 쿠키 데이터 중에서 세션 아이디를 꺼낸다.
    // 그 아이디에 해당하는 세션 객체를 찾아서 리턴할 것이다.
    HttpSession session = request.getSession();
    
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>입력결과</h1>");
    out.println("<p>다음 정보들 [<br>");
    out.printf("이름 : %s<br>\n",session.getAttribute("name"));
    out.printf("나이 : %s<br>\n",session.getAttribute("age"));
    out.printf("전화 : %s<br>\n",session.getAttribute("tel"));
    out.printf("이메일 : %s<br>\n",session.getAttribute("email"));
    out.println("]을 저장하였습니다.</p>");
    out.println("</body>");
    out.println("</html>");
  }
}
/*
#
-
 */
