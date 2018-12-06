//클라이언트에서 서버로 쿠키 전달하기 - HTTP 요청 프로토콜과 쿠키
package step10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step10/servlet31")
public class Servlet31 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    // 1) 쿠키 받기
    Cookie[] cookies = request.getCookies();
    // 2) 클라이언트로 부터 받은 쿠키 출력하기
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("쿠키 받았음!<br>");
    
    for (Cookie cookie : cookies) {
      out.printf("%s = %s<br>",cookie.getName(),
          URLDecoder.decode(cookie.getValue(),"UTF-8"));
    }
  }
}
/* 
# 쿠키(cookie) 받기
- 클라이언트로 쿠키를 보낼 때 URL로 인코딩 했다면,
  클라이언트로부터 쿠키를 받을 때 URL 디코딩 해야 한다.
- 웹브라우저와 서블릿 컨테이너가 파라미터 값을 주고 받을 때
  URL 인코딩과 URL 디코딩을 자동으로 수행한다.
- 그러나 쿠키 값에 대해서는 자동으로 수행하지 않는다.
  따라서 쿠키를 보내거나 받을 때 개발자가 직접 인코딩, 디코딩 해야한다.

# HTTP 요청 프로토콜과 쿠키
GET /web02/step10/servlet31 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*\/*;q=0.8
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
Cookie: name=%ED%99%8D%EA%B8%B8%EB%8F%99; age=20; tel=010-1234-4321

 */
