//POST 요청 시 한글 깨짐 현상 해결
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet17")
public class Servlet17 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();
    out.println("Servlet17");
    
    out.printf("요청 method : %s\n",httpreq.getMethod());
//    GET 요청,  POST 요청에 상관 없이 파라미터 값에 꺼낸 방법은 같다
    httpreq.setCharacterEncoding("UTF-8");
    out.printf("name : %s\n",httpreq.getParameter("name"));
    out.printf("email : %s\n",httpreq.getParameter("email"));
    out.printf("tel : %s\n",httpreq.getParameter("tel"));
    
  }
}
/* 
# 요청 파라미터 값의 한글 깨짐 현상
=> 서블릿 컨테이너는 주고 받는 데이터의 기본 문자 집합을 ISO-8859-1로 간주한다.
=> 한글을 깨지지 않게 하려면,

1) GET 요청
  => 서블릿 컨테이너의 매뉴얼에 따라 설정하라.
  
2) POST 요청  
  => 서블릿 컨테이너의 종류에 상관없이 요청 데이터를 꺼내기 전에
     파라미터 값이 어떤 문자 집합으로 인코딩 되었는지 다음과같 이 지정하면 된다.
     
     request.setCharacterEncoding("UTF-8");
  => 반드시 ! getParameter()를 최초로 호출하기 전에 문자 집합을 지정해야 한다.
     한 번 이라도 getParameter()를 호출한다면 위의 명령은 소용없다.
     
=> POST 방식으로 넘어오는 데이터는 프로그램 코드로 처리해야 한다.
   서블릿 컨테이너의 설정으로 처리할 수 없다.
   
# URL 인코딩
=> 인터넷 상에서 통신을 할 때 기본 문자 집합은 7비트 ASCII 이다.
=> 이유 ?
   초창기 네트워크 장비가 7비트를 기준으로 만들어져 있다.
=> 한글은 8비트 2개를 사용하여 표현한다.
   예) 가 --> EUC-KR  : B0A1    --> 10110000 10100001
              Unicode : AC00    --> 10101100 00000000
              UTF-8   : EAB080  --> 11101010 10110000 10000000
   7비트 장비에 들어가면 첫 비트가 짤린다.
=> 해결책?
   한글(8비트 여러개)을 ASCII(7비트)로 변환하여 보낸다.
   한글 8비트 : EAB080(11101010 10110000 10000000) 
   ASCII 7비트 : "%EA%B0%80" (25 45 41 25 42 30 25 38 30)HEX
                --> 00100101 01000101 01000001 00100101 ....
=> ASCII 코드는 무조건 7비트이기 때문에 안전하게 다른 장비로 데이터를 보낼 수 있다.
=> URL 인코딩은 7비트 장비에 들어 갔을 때 데이터가 짤릴 수 있는 경우에 사용한다.
=> 웹 브라우저는 웹 서버에 데이터를 보낼 떄, 
   한글과 같이 8비트 모두를 사용하는 데이터에 대해서는 URL인코딩 하여 보낸다.
=> 웹 서버는 URL 인코딩 데이터를 원래의 데이터로 자동 변환한다.
=> 개발자가 URL 인코딩과 URL 디코딩을 할 필요는 없다.
=> 그러나 URL 인코딩이 뭔지는 이해해야 한다.
   
# 요청 프로토콜 예)
POST http://localhost:8080/web02/step04/servlet18 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 56
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*\\/*;q=0.8
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Referer: http://localhost:8080/web02/step04/upload.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

 */

