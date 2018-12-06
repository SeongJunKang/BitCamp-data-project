// 서버에서 클라이언트로 쿠키 전달하기 - HTTP 응답 프로토콜과 쿠키
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
    out.println("<form action='servlet38' method='post'>");
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
    
    //만약 id 저장이 체크되어 있다면, id 값을 쿠키로 클라이언트 에게 보낸다.
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
    if(id.equals("admin") && password.equals("1111")) {
      out.println("로그인 성공<br>");
    } else {
      out.println("로그인 실패<br>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
/*
#
-
 */
