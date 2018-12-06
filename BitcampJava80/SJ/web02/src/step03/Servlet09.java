// 기타 요청과 관련된 정보를 추출하기
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet09")
public class Servlet09 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("Servlet09");
    // 클라이언트가 보낸 데이터의 문자 집합을 알아낸다.
    // 클라이언트가 보낸 데이터가 없거나 문자 집합을 알지 못하면 null리턴한다.
    out.printf("%s = %s \n", "getCharacterEncoding()", req.getCharacterEncoding());

    // 클라이언트가 보낸 데이터가 있다면 그 데이터의 길이
    out.printf("%s = %s \n", "getCountentLength()", req.getContentLength());

    // 클라이언트가 보낸 데이터가 있다면 그 데이터의 MIME 타입
    out.printf("%s = %s \n", "getContentType()", req.getContentType());

    out.printf("%s = %s \n", "getProtocol()", req.getProtocol());
    out.printf("%s = %s \n", "getRemoteHost()", req.getRemoteHost());
    out.printf("%s = %d \n", "getRemotePort()", req.getRemotePort());
    out.printf("%s = %s \n", "getRemoteAddr()", req.getRemoteAddr());
    out.printf("%s = %s \n", "getScheme()", req.getScheme());
  }
}
