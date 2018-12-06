package step04.servlet22;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/calculator3/minus")
public class MinusServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    
    int a = Integer.parseInt(httpreq.getParameter("a"));
    int b = Integer.parseInt(httpreq.getParameter("b"));
    httpreq.setAttribute("result",a-b);
  }
}
