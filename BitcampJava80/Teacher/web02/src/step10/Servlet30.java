package step10;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step10/servlet30")
public class Servlet30 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    // 1) 쿠키 만들기
    Cookie cookie1 = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
    Cookie cookie2 = new Cookie("age", "20");
    Cookie cookie3 = new Cookie("tel", "111-1111");
    
    // 2) 응답 프로토콜에 쿠키 정보 첨부하기
    response.addCookie(cookie1);
    response.addCookie(cookie2);
    response.addCookie(cookie3);
    
    // 3) 클라이언트에게 응답하기
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("쿠키 보냈음!");
  }
}

/*
# 쿠키(cookie)
- 서버가 클라이언트에게 맡기는 데이터이다.
- 문자열만 가능하다.
- ISO-8859-1 만 가능하다.
- 한글? 불가능하다. 
  해결책? URLEncoding으로 한글을 영문으로 만들어 보낼 수 있다.
- 클라이언트는 서버가 맡긴 데이터를 보관하고 있다가
  다시 서버에 요청할 때 전달해야 한다.

# HTTP 응답 프로토콜과 쿠키
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: name=%ED%99%8D%EA%B8%B8%EB%8F%99
Set-Cookie: age=20
Set-Cookie: tel=111-1111
Content-Type: text/plain;charset=UTF-8
Content-Length: 19
Date: Wed, 18 May 2016 02:49:32 GMT

  
 */








