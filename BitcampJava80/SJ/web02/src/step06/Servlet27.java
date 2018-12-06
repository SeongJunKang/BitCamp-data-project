//리프레시 -HTML <meta>태그 이용.
package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step06/servlet27")
public class Servlet27 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {
    resp.setContentType("text/HTML;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<meta http-equiv='Refresh' content='5;url=http://naver.com'>");
    out.println("<title>refresh</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>HTML meta 태그를 이용하여 refresh 구현</p>");
    out.println("<p>'브라우저야 5초 후에 내가 알려준 url로 요청해라 !'</p>");
    out.println("<p> meta http-equiv='Refresh' content='5;url=http://naver.com' </p>");
    out.println("<p>5초후 다른 화면으로 이동합니다.</>");
    out.println("</body>");
    out.println("</html>");
  }
}
