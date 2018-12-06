//GET/POST 요청을 분리하여 처리하기3 - doGet() , doPost() 실무용
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet26")
public class Servlet26 extends HttpServlet {

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
    out.println("<title>POST 요청</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>POST 요청 예</h1>");
    out.println("<form action=\"servlet26\" method=\"post\">");
    out.println(" 이름   : <input type=\"text\" name=\"name\"><br>");
    out.println(" 이메일 : <input type=\"text\" name=\"email\"><br>");
    out.println(" 전화   : <input type=\"text\" name=\"tel\"><br>");
    out.println("<button>보내기</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/HTML;charset=UTF-8");
    PrintWriter out = httpres.getWriter();
    httpres.setContentType("text/HTML;charset=UTF-8");
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>서블릿25</title>");
    out.println("</head>");
    out.println("<body>");
    out.printf(" 이름   : %s<br>\n",httpreq.getParameter("name"));
    out.printf(" 이메일 : %s<br>\n",httpreq.getParameter("email"));
    out.printf(" 전화   : %s<br>\n",httpreq.getParameter("tel"));
    out.println("</body>");
    out.println("</html>");
  }
}

/* 
#

 */

