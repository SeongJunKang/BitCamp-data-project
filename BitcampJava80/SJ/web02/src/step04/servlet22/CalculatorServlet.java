package step04.servlet22;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet22")
public class CalculatorServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();

    // 1) 요청을 다른 서블릿에게 전달할 배달자 준비
    RequestDispatcher rd = null;
    // 2) 헤더를 출력할 서블릿 실행
    rd = httpreq.getRequestDispatcher("/step04/calculator3/header");
    rd.include(httpreq, httpres); //헤더를 실행하고 되돌아온다.
    
    switch (httpreq.getParameter("op")) {
      case "+":
        rd = httpreq.getRequestDispatcher("/step04/calculator3/plus");
        break;
      case "-":
        rd = httpreq.getRequestDispatcher("/step04/calculator3/minus");
        break;
      case "*":
        rd = httpreq.getRequestDispatcher("/step04/calculator3/multiple");
        break;
      case "/":
        rd = httpreq.getRequestDispatcher("/step04/calculator3/divide");
        break;
      default:
        out.println("지원하지 않는 연산자 입니다.");
        return;
    }
    // 3) 계산을 수행하는 서블릿을 실행한다.
    rd.include(httpreq, httpres); // 계산을 수행한 후 되돌아 온다.
    // 4) 계산 결과를 출력한다.
    // 다른 서블릿에서 수행한 작업 결과를 받기.
    // => ServletRequest 바구니에 담겨있는 값을 꺼낸다.
    if (httpreq.getAttribute("result").getClass() == Integer.class) {
      int result =  (int)httpreq.getAttribute("result");
      out.printf("%s %s %s = %d\n",
          httpreq.getParameter("a"),
          httpreq.getParameter("op"),
          httpreq.getParameter("b"),
          result);
    } else if (httpreq.getAttribute("result").getClass() == Float.class) {
      float result =  (float)httpreq.getAttribute("result");
      out.printf("%s %s %s = %.2f\n",
          httpreq.getParameter("a"),
          httpreq.getParameter("op"),
          httpreq.getParameter("b"),
          result);
    }
    // 5) 꼬릿말을 출력할 서블릿을 실행한다.
    rd = httpreq.getRequestDispatcher("/step04/calculator3/tailer");
    rd.include(httpreq, httpres); // 꼬리말을 출력한 후 되돌아온다.
  }
}

/*
# ServletRequest 보관소
- ServletRequest는 요청 정보를 다루는 것 외에 보관소의 역할도 겸하고 있다.
- forward나 include 에 묶여있는 서블릿끼리 데이터를 주고 받을 때 사용한다.

# 서블릿 기술에서 제공하는 다양한 보관소
1) ServletContext
- 웹 애플리케이션의 정보를 다루는것 외에[ 보관소 역할도 겸하고 있다.
- 사용범위)
  => 사용 범위를 이해하려면, 이 객체가 언제 생성되고 언제 제거되는지 이해해야한다.
  => 웹 애플리케이션이 시작될 때 생성됨.
  => 웹 애플리케이션 당 한 개만 생성됨.
  => 웹 애플리케이션이 멈출 때 제거됨.
  

2) HttpSession
- 세션을 다루는 것 외에 보관소의 역할도 겸하고 있다.
- 사용범위)
  => 세션이 없을 때 생성됨
  => 타임 아웃되거나 세션을 무효화할 떄 제거됨.

3) ServletRequest
- 요청을 다루는 것 외에 보관소의 역할도 겸하고 있다.
- 사용범위)
  => 요청이 들어올 떄 생성됨.
  => 응답을 하면 제거됨.

 */
