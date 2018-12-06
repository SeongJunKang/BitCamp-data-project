// HTTP 프로토콜의 요청 방식을 식별하기
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step03/servlet12")
public class Servlet12 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();
    out.println("Servlet12");

    out.printf("요청 방식 => %s \n",httpreq.getMethod());
    
  }
}
/*
# HTTP request 프로토콜
GET /web02/step03/servlet12?name=aaa&email=bbb&tel=111 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9, ...
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

# HTTP 요청 프로토콜 분석
1) GET /web02/step03/servlet12?name=aaa&email=bbb&tel=111 HTTP/1.1
=> Request Line : method request-uri http-version (CRLF)
  => method       : GET, POST, PUT, DELETE, TRACE, HEAD 등
  => request-uri  : 요청하는 자원의 웹주소
  => http-version : 프로토콜 이름 및 버전
  
2) 일반 헤더
=> 요청과 응답 모두에 사용할 수 있는 헤더
=> 예)
Connection
Cache-Control
Upgrade-Insecure-Requests

3) 요청 헤더
=> 요청할 때만 보낼 수 있는 헤더
=> 예)
Host: localhost:8080
Accept: text/html,application/xhtml+xml,application/xml;q=0.9, ...
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

4) 엔티티 헤더
=> POST 방식으로 서버에 데이터를 보낼 떄 사용하는 헤더
=> 보내는 데이터의 정보를 표현한다.
=> 위의 프로토콜은 GET 방식이기 때문에 Entity 헤더를 찾을 수 없다.

5) 빈줄
=> 항상 요청 헤더의 끝을 표시하기 위해 빈줄을 삽입해야 한다.
 */


