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

@WebServlet("/step11/servlet41/page2")
public class Servlet41B extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // HttpSession 보관소에 저장.
    HttpSession session = request.getSession();
    session.setAttribute("name", request.getParameter("name"));
    session.setAttribute("age", request.getParameter("age"));
    
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>추가정보</h1>");
    out.println("<form action='page3' method='post'>");
    out.println("전화 : <input type='text' name='tel'><br>");
    out.println("이메일 : <input type='email' name='email'><br>");
    out.println("<button>다음</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
/*
# request.getSession();
1. 요청 프로토콜의 쿠키 데이터 중에서 세션 아이디가 있는지 검사한다.
  2. 있다면, 그 아이디의 세션이 유효한지 (타임아웃이 되지않았는지) 검사한다.
    3. 유효하다면 => 그 세션 객체를 리턴한다.
    4. 유효하지 않다면 => 5번
5. 없다면, 세션을 새로 만든다.
  6. 새로 만든 세션을 리턴한다.
  
=> 세션을 새로 만든 경우 응답할 때 세션 아이디를 쿠키 정보로 클라이언트에게 보낸다.

 */
