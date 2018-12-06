//  HTTP 응답 헤더 추가하기 - HTTP 응답 프로토콜 분석
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
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();
    out.println("Servlet13");
    
    //응답 헤더 추가하기
    httpres.setHeader("Bitcamp-class", "java 80");
    
//    500 상태코드 에러 확인
//    => 서블릿 실행 중 오류가 발생 하면 응답 상태 코드가 500이 된다.
//    throw new RuntimeException("일부러 오류 발생!");
    
//    301 상태 코드
//    => 다른 URL로 이동할 것을 클라이언트에게 알려줄 때.
//    httpres.sendRedirect("http://www.google.com");
    
  }
}
/*
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Bitcamp-class: java 80
Content-Type: text/plain;charset=UTF-8
Content-Length: 11
Date: Fri, 06 May 2016 00:50:47 GMT

1) 상태 라인(Status-Line)
HTTP/1.1 200 OK
=> HTTP-Version Status-Code Reason-Phrase (CRLF)
=> HTTP-version : HTTP/1.1
=> Status-Code(상태 코드) : 200
-------------------------------------------------------------------------
- 1xx : 요청을 어떻게 처리할 지 정
- 2xx : 요청 처리를 성공적으로 수행했음을 의미
- 3xx : 요청 처리 후 이동해야할 페이지가 있음을 의미
- 4xx : 클라이언트 요청 오류
- 5xx : 서버 실행오류
-------------------------------------------------------------------------
- 200 : OK => 정상적 처리
- 301 : Moved Permanently => 다른 페이지를 다시 요청할 것을 안내할 때(리다이렉트).
- 302 : Found => 다른 URL로 이동할 것을 알려줄 때(리다이렉트).
- 304 : Not Modified => 로컬에 캐시된 것과 같음을 알릴 때.
        -> 로컬 캐시 메모리에 요청하는 자원이 있다. 즉 이전에 서버로부터 받은
           데이터가 있다.
        -> 클라이언트는 같은 자원을 서버에 요청한다.
        -> 서버는 클라이언트가 요청한 자원을 찾는다.
        -> 만약 클라이언트가 요청한 자원의 날짜를 보낸다면,
           현재 서버에 있는 자원의 날짜와 비교한다.
        -> 클라이언트가 갖고 있는 자원과 같은 날짜라면 서버는 304코드를 보낸다.
           그리고 컨텐츠를 보내지 않는다.
- 400 : Bad Request => 요청 프로토콜이 문법에 맞지 않을 때.
- 403 : Forbidden => 요청한 자원에 대해 실행 권한이 없을 때.
- 404 : Not Found => 요청한 자원을 찾을 수 없을 때.
- 500 : Internal Server Error =>
-------------------------------------------------------------------------
=> Reason-Phrase : OK

2) 일반 헤더
=> HTTP 요청 프로토콜과 같다. .Servlet12 참조

3) 응답 헤더
=> 응답할 떄 클라이언트로 보낼 수 있는 헤더.
=> 예) Server: Apache-Coyote/1.1

4) 엔티티 헤더
=> 서버가 보내는 데이터의 정보
=> 예)
  Content-Type: text/plain;charset=UTF-8
  Content-Length: 11

5) 빈줄
=> 헤더 정보와 데이터를 구분하기 위함.

6) 메시지 본문(Message-body)
=> 클라이언트에 보내는 본문 데이터.

# HTTP 프로토콜 형식
1) 요청
Request-Line (CRLF)
(일반헤더 | 요청헤더 | 엔티티 헤더 (CRLF))*
(CRLF)
message-body <= POST 요청일 때.

2) 응답
Status-Line (CRLF)
(일반헤더 | 응답헤더 | 엔티티 헤더 (CRLF))*
(CRLF)
message-body <= 서버가 클라이언트로 보내는 데이터

 */

