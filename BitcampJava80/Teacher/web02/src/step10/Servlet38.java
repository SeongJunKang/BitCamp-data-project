package step10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step10/servlet38")
public class Servlet38 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    // 쿠키로 저장된 아이디 값 알아내기
    String id = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("id")) {
        id = cookie.getValue();
        break;
      }
    }
    
    // 로그인 폼 출력 
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");
    out.println("<form action='servlet38' method='post'>");
    out.printf("아이디: <input type='text' name='id' value='%s'><br>\n", id);
    out.println("암호: <input type='password' name='password'><br>");
    out.println("<input type='checkbox' name='idsave'>아이디 저장<br>");
    out.println("<button>로그인</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    
    //만약 아이디 저장이 체크되어 있다면, 
    //아이디 값을 쿠키로 클라이언트에게 보낸다.
    if (request.getParameter("idsave") != null) {
      Cookie cookie = new Cookie("id", id);
      cookie.setMaxAge(60 * 60 * 24 * 5); // 유효기간 5일
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("id", "");
      cookie.setMaxAge(0); // 쿠키를 삭제하라!
      response.addCookie(cookie);
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>로그인 결과</h1>");
    if (id.equals("admin") && password.equals("1111")) {
      out.println("로그인 성공입니다!");
    } else {
      out.println("로그인 실패입니다!");
    }
    out.println("</body>");
    out.println("</html>");
  }
}










