/* 주제: HTTP 응답 헤더 추가하기 - HTTP 응답 프로토콜 분석 */
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step03/servlet13")
public class Servlet13 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    // 응답 헤더 추가하기
    response.setHeader("bitcamp-class", "java 80");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("Hello!");
    
    //500 상태 코드
    //=> 서블릿 실행 중 오류가 발생하면, 응답 상태 코드가 500이 된다.
    //throw new RuntimeException("오호라..일부러 오류 발생!");
    
    //302 상태 코드
    //=> 다른 URL로 갈 것을 클라이언트에게 알려 줄 때,
    //response.sendRedirect("http://www.google.com"); // 다른 사이트
    //response.sendRedirect("servlet12"); // 현재 URL을 기준으로 이동
    
    
  }
}

/*
# HTTP response 프로토콜
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
bitcamp-class: java 80
Content-Type: text/plain;charset=UTF-8
Content-Length: 8
Date: Fri, 06 May 2016 00:51:34 GMT

1) 상태 라인(Status-Line)
HTTP/1.1 200 OK
=> HTTP-Version Status-Code Reason-Phrase (CRLF)
=> HTTP-Version : HTTP/1.1
=> Status-Code : 200
=> Reason-Phrase : OK
=> 상태코드
1xx : 요청을 어떻게 처리할 지 정보
2xx : 요청 처리를 성공적으로 수행했음을 의미
3xx : 요청 처리 후 이동해야할 페이지가 있음을 의미
4xx : 클라이언트 요청 오류
5xx : 서버 실행 오류 

200 : OK => 정상적으로 처리를 했을 때
301 : Moved Permanently => 다른 페이지를 다시 요청할 것을 안내할 때, 리다이렉트
302 : Found => 다른 URL로 이동할 것을 알려줄 때, 리다이렉트
304 : Not Modified => 로컬에 캐시된 것과 같음을 알릴 때,
      => 로컬 캐시 메모리에 요청하는 자원이 있다. 
         즉 이전에 서버로부터 받은 데이터가 있다.
      => 클라이언트는 같은 자원을 서버에 요청한다.
         요청할 때 이전에 받은 자원의 날짜를 서버에 보낸다.
      => 서버는 클라이언트가 요청한 자원을 찾는다.
      => 만약 클라이언트가 요청한 자원의 날짜를 보낸다면,
         현재 서버에 있는 자원의 날짜와 비교한다.
      => 클라이언트가 갖고 있는 자원과 같은 날짜라면 서버는 304 코드를 보낸다.
         그리고 콘텐츠를 보내지 않는다.
      => 클라이언트가 갖고 있는 자원보다 더 최근 자원이라면,(변경되었다면)
         200 코드와 콘텐츠를 함께 보낸다.    
400 : Bad Request => 요청 프로토콜이 문법에 맞지 않을 때,
403 : Forbidden => 요청한 자원에 대해 실행 권한이 없을 때,
404 : Not Found => 요청한 자원을 찾을 수 없을 때,
500 : Internal Server Error => 요청 처리 중에 오류가 발생했을 때,

2) 일반 헤더
=> HTTP 요청 프로토콜과 같다. Servlet12.java 참조할 것.

3) 응답 헤더
=> 응답할 때 클라이언트로 보낼 수 있는 헤더.
=> 예)
Server: Apache-Coyote/1.1

4) 엔티티 헤더
=> 서버가 보내는 데이터에 대한 정보
=> 예)
Content-Type: text/plain;charset=UTF-8
Content-Length: 8

5) 빈줄
=> 헤더 정보와 데이터를 구분하기 위함.

5) 메시지 본문(message-body)
=> 클라이언트에 보내는 본문 데이터. 

# HTTP 프로토콜 형식
1) 요청
Request-Line (CRLF)
(일반헤더 | 요청헤더 | 엔티티 헤더 (CRLF))*
(CRLF)
message-body <== POST 요청일 때,

2) 응답
Status-Line (CRLF)
(일반헤더 | 응답헤더 | 엔티티 헤더 (CRLF))*
(CRLF)
message-body <== 서버가 클라이언트로 보내는 데이터 

 */

















