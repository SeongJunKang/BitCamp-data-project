//웹 브라우저로 출력하기
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet02")
public class Servlet02 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    // 출력도구를 준비한다.
    out.println("Servlet02");
    out.println("한글");
  }

}
/* service() 메서드의 파라미터
 * 1) ServletRequest
 *  =>클라이언트 요청을 다루는 기능을 갖고 있다.
 * 2) ServletResponse
 *  => 클라이언트에게 응답할 때 필요한 기능을 갖고 있다.
 *  
 */