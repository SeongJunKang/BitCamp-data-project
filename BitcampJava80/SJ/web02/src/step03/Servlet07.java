// 파라미터 이름과 값을 알아내기
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet07")
public class Servlet07 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    Enumeration<String> names = req.getParameterNames();
    //파라미터 이름 꺼내기
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    String name = null;
    while(names.hasMoreElements()) {
      name = names.nextElement();
      out.printf("%s = %s \n",name,req.getParameter(name));
    }
    out.println("Servlet07");
  }
}
