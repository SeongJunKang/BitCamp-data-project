package step10;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step10/servlet39")
public class Servlet39 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    // 쿠키로 저장된 마지막 방문일 알아내기
    String lastVisited = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("lastVisited")) {
        lastVisited = cookie.getValue();
        break;
      }
    }
    
    // 현재 방문일을 클라이언트에게 쿠키로 보내기
    response.addCookie(new Cookie(
        "lastVisited", 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>환영합니다.</h1>");
    out.printf("마지막 방문일: %s\n", lastVisited);
    out.println("</body>");
    out.println("</html>");
  }
  
  
}








