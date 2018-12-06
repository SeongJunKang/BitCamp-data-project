package step04.servlet20;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet20")
public class CalculatorServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    // 서블릿을 만들 때 마다 다음과 같이 요청 데이터의 문자 집합을 
    // 지정하는 것은 매우 번거롭고 귀찮은 일이다.
    // 해결책 ?
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();


    out.println("*********************************************************");
    // 1) 요청을 다른 서블릿에게 전달할 배달자 준비
    RequestDispatcher rd = null;
    switch (httpreq.getParameter("op")) {
      case "+":
        rd = httpreq.getRequestDispatcher("/step04/calculator/plus");
        break;
      case "-":
        rd = httpreq.getRequestDispatcher("/step04/calculator/minus");
        break;
      case "*":
        rd = httpreq.getRequestDispatcher("/step04/calculator/multiple");
        break;
      case "/":
        rd = httpreq.getRequestDispatcher("/step04/calculator/divide");
        break;
      default:
        out.println("지원하지 않는 연산자 입니다.");
        return;
    }
    // 2) 요청 배달자를 통해 다른 서블릿으로 요청을 전달한다.
    rd.forward(httpreq, httpres);
    
    // forward하면 다시 메인 서블릿으로 돌아오지 않는다.
    // 따라서 다음 코드는 결코 실행되지 않는다.
    out.println("*********************************************************");
  }
}

/*
# Forward 실행 위임 방식
- 조건에 따라 실행을 위임하여 작업을 처리할 때 사용하는 방식.
- 조건에 따라 작업을 분기시킬 때 주로 사용한다.
- 다른 서블릿으로 실행을 위임하는 순간, 메인 서블릿이 출력한 것은 취소된다.
- 아니, 메인 서블릿이 클라이언트에게 이미 출력했는데 어떻게 출력을 취소할 수 있나요 ?
  => out.println() 과 같이 출력을 하면 서블릿 내부에 마련된 버퍼에 저장된다.
  => 즉 클라이언트로 출력된 것이 아니다.
  => 그래서 출력을 취소할 수 있다.
 */
