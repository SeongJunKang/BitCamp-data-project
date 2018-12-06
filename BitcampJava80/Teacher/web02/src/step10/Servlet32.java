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

@WebServlet("/other/servlet32")
public class Servlet32 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    // 1) 쿠키 받기
    Cookie[] cookies = request.getCookies();
    
    // 2) 클라이언트로부터 받은 쿠키를 출력하기
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("쿠키 받았음!");
    
    for (Cookie cookie : cookies) {
      out.printf("%s=%s\n", cookie.getName(), 
          URLDecoder.decode(cookie.getValue(), "UTF-8"));
    }
  }
}

/*
# 쿠키를 보낸 경로가 아닌 다른 경로에게 요청할 때,
- 보낸 경로와 다르다면 쿠키를 전달하지 않는다.
- 그러나 하위 경로는 같은 경로로 취급한다.
- 클라이언트가 다른 경로에 대해 쿠키를 보내지 않는 이유?
  => 쿠키를 보내는 것은 전송 데이터의 양을 증가시킨다.
  => 쓸데없이 모든 요청에 대해 쿠키를 보낼 필요는 없다.
     => 요청 데이터를 전송하는 크기를 줄이기 위함. 
  
# HTTP 요청 프로토콜과 쿠키
GET /web02/other/servlet32 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4


  
 */








