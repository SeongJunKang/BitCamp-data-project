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

@WebServlet("/step10/servlet37")
public class Servlet37 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    // 1) 쿠키 만들기
    Cookie cookie1 = new Cookie("name3", URLEncoder.encode("홍길동", "UTF-8"));
    cookie1.setMaxAge(20); // 유효기간(초) 설정하기
    Cookie cookie2 = new Cookie("age3", "20");
    cookie2.setMaxAge(40);
    Cookie cookie3 = new Cookie("tel3", "111-1111");
    cookie3.setMaxAge(60);
    
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
# 쿠키 유효기간 설정하기
- 유효기간을 설정하지 않으면,
  웹 브라우저를 닫을 때까지 유효하다.
- 유효기간을 설정하면,
  그 시간까지는 컴퓨터를 껐다 켜더라도 유효하다.

# HTTP 응답 프로토콜과 쿠키
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: name3=%ED%99%8D%EA%B8%B8%EB%8F%99; Expires=Wed, 18-May-2016 03:38:33 GMT
Set-Cookie: age3=20; Expires=Wed, 18-May-2016 03:38:53 GMT
Set-Cookie: tel3=111-1111; Expires=Wed, 18-May-2016 03:39:13 GMT
Content-Type: text/plain;charset=UTF-8
Content-Length: 19
Date: Wed, 18 May 2016 03:38:13 GMT
  
 */








