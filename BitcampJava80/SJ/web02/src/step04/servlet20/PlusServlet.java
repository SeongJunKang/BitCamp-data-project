package step04.servlet20;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/calculator/plus")
public class PlusServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();
    
    int a = Integer.parseInt(httpreq.getParameter("a"));
    int b = Integer.parseInt(httpreq.getParameter("b"));
    out.printf("%d + %d  = %d\n",a,b,a+b);
  }
}
