//파라미터 이름과 값을 알아내기2
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet08")
public class Servlet08 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("Servlet08");
    //파라미터 이름 및 값을 묶어서 한묶음으로 꺼내기
    Map<String, String[]> paramMap = req.getParameterMap();
    
    for (Entry<String,String[]> entry : paramMap.entrySet()) {
      out.printf("%s = %s \n",entry.getKey(),entry.getValue()[0]);
    }
  }
}
