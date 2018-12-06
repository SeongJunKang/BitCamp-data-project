package step04.servlet21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet21")
public class CalculatorServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();

    out.println("*********************************************************");
    // 1) 요청을 다른 서블릿에게 전달할 배달자 준비
    RequestDispatcher rd = null;
    switch (httpreq.getParameter("op")) {
      case "+":
        rd = httpreq.getRequestDispatcher("/step04/calculator2/plus");
        break;
      case "-":
        rd = httpreq.getRequestDispatcher("/step04/calculator2/minus");
        break;
      case "*":
        rd = httpreq.getRequestDispatcher("/step04/calculator2/multiple");
        break;
      case "/":
        rd = httpreq.getRequestDispatcher("/step04/calculator2/divide");
        break;
      default:
        out.println("지원하지 않는 연산자 입니다.");
        return;
    }
    // 2) 요청 배달자를 통해 다른 서블릿으로 요청을 전달한다.
    rd.include(httpreq, httpres);
    
    out.println("*********************************************************");
  }
}

/*
# include 실행 위임 방식
- 한 작업을 여러 서블릿이협력하여 수행할 때 사용하는 방식이다.
- 메인 서블릿에서 기본 작업을 수행하고, 다른 서블릿이 부분 작업을 수행한다. 
 */
