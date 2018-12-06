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
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    String tel = request.getParameter("tel");
    String email = request.getParameter("email");
    
    // HttpSession 보관소에 저장
    // => request.getSession()이 리턴하는 객체는
    //    Servlet41B에서 만든 세션 객체이다.
    // => 왜? 요청 프로토콜에 세션아이디가 쿠키 값으로 들어 있다.
    // => 따라서 그 세션아이디로 기존에 생성된 세션을 찾아서 리턴한 것이다.
    HttpSession session = request.getSession();
    session.setAttribute("tel", tel);
    session.setAttribute("email", email);
    
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>입력 내용</h1>");
    out.println("<form action='page4' method='post'>");
    out.printf("이름: %s<br>\n", session.getAttribute("name"));
    out.printf("나이: %s<br>\n", session.getAttribute("age"));
    out.printf("전화: %s<br>\n", tel);
    out.printf("이메일: %s<br>\n", email);
    out.println("<button>완료</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  
}








