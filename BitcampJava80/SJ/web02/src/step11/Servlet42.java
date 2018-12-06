// GET(로그인 폼 출력), POST(로그인 처리)
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/step11/login")
public class Servlet42 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    String id = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("id")) {
        id = cookie.getValue();
        break;
      }
    }
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");
    out.println("<form action='login' method='post'>");
    out.printf("아이디 : <input type='text' name='id' value='%s' ><br>\n",id);
    out.println("비밀번호 : <input type='password' name='password'><br>");
    if(id.equals("")) {
      out.println("<input type='checkbox' name='idsave'>아이디 저장<br>");
    } else {
      out.println("<input type='checkbox' name='idsave' checked='checked'>아이디 저장<br>");
    }
    out.println("<button>로그인</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    
    // 로그인 정보를 세션에 저장.
    HttpSession session = request.getSession();
    if (id.equals("hong") && password.equals("1111")) {
      Member member = new Member(100, "홍길동", "hong", "hong@test.com", "1111","111-1111" );
      session.setAttribute("loginUser", member);
      response.setHeader("Refresh", "2;url=main");
    } else {
      session.invalidate();
      // 로그인 실패시 기존 세션을 무효화 시키고 새 세션 준비
      session = request.getSession();
    }
    
    if (request.getParameter("idsave") != null ) {
      Cookie idCookie = new Cookie("id",id);
      idCookie.setMaxAge(604800); //60 * 60 * 24 * 7
      response.addCookie(idCookie);
    } else {
      Cookie idCookie = new Cookie("id","");
      idCookie.setMaxAge(0);    //쿠키를 삭제하라
      response.addCookie(idCookie);
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>로그인 결과</h1>");
    if(session.getAttribute("loginUser") != null) {
      out.println("로그인 성공<br>");
    } else {
      out.println("로그인 실패<br>");
    }
    out.println("</html>");
  }
}
/*
#
-
 */
