//서블릿 초기화 파라미터 다루기
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet25")
public class Servlet25 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) throws ServletException, IOException {
//    httpres.setContentType("text/plain;charset=UTF-8");
    httpres.setContentType("text/HTML;charset=UTF-8");
    httpreq.setCharacterEncoding("UTF-8");
   //#랜더링 : HTML해석에서 브라우저에 그리길 원한다. 
    if(httpreq.getMethod().equals("GET")) {
      get(httpreq,httpres);
    } else if (httpreq.getMethod().equals("POST")) {
      post(httpreq,httpres);
    } else {
      PrintWriter out = httpres.getWriter();
      httpres.setContentType("text/plain;charset=UTF-8");
      out.println("지원하지 않는 HTTP 입니다.");
    }
  }
  
  private void get(HttpServletRequest httpreq, HttpServletResponse httpres) throws ServletException, IOException {
    PrintWriter out = httpres.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>POST 요청</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>POST 요청 예</h1>");
    out.println("<form action=\"servlet25\" method=\"post\">");
    out.println(" 이름   : <input type=\"text\" name=\"name\"><br>");
    out.println(" 이메일 : <input type=\"text\" name=\"email\"><br>");
    out.println(" 전화   : <input type=\"text\" name=\"tel\"><br>");
    out.println("<button>보내기</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  private void post(HttpServletRequest httpreq, HttpServletResponse httpres) throws ServletException, IOException {
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
 * 
 */

