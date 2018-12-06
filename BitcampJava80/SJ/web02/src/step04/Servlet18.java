//파일 업로드와 HTTP 요청 프로토콜 분석
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet18")
public class Servlet18 extends HttpServlet {

  private static final long serialVersionUID = 1L;
  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) 
      throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = httpres.getWriter();
    out.println("Servlet18");
    
    out.printf("요청 method : %s\n",httpreq.getMethod());
//  멀티 파트 형식으로 데이터를 받은 경우,
//    다음과 같이 일반적인 방법으로 값을 꺼낼 수 없다.
//    다음 출력 결과는 모두 null일 것이다.
    
    httpreq.setCharacterEncoding("UTF-8");
    out.printf("name : %s\n",httpreq.getParameter("name"));
    out.printf("email : %s\n",httpreq.getParameter("email"));
    out.printf("tel : %s\n",httpreq.getParameter("tel"));
    out.printf("photo : %s\n",httpreq.getParameter("photo"));
//    해결책?
//        =>클라이언트가 보낸 데이터를 파트별로 분석하고 처리해야한다.
//      개발자가 직접 ? 노~노~
//          멀티파트 데이터를 전문적으로 처리하는 외부 라이브러리를 사용하라.
//          Servlet19.java 참조
//          외부라이브러리 ?
//              보통 아파치 그룹의 공통 라이브러리를 많이 사용한다.
  }
}
/* 
#파일 업로드
=> 웹 브라우저에서 파일을 업로드 하려면,
   "POST + 멀티파트"로 지정해야 한다.
ex) <form action="..." method="post" enctype="multipart/form-data"> ... </form>
=> form 태그의 enctype 속의 기본 값은 다음과 같다.
   "application/x-www-form-urlencoded"

# 멀티파트로 파일 업로드하는 HTTP 요청 프로토콜 예)
POST http://localhost:8080/web02/step04/servlet18 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 155149
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*\\/*;q=0.8
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryQ0phyISBKf0mXa15
Referer: http://localhost:8080/web02/step04/upload.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

------WebKitFormBoundaryQ0phyISBKf0mXa15
Content-Disposition: form-data; name="name"

나다
------WebKitFormBoundaryQ0phyISBKf0mXa15
Content-Disposition: form-data; name="email"

asd
------WebKitFormBoundaryQ0phyISBKf0mXa15
Content-Disposition: form-data; name="tel"

123
------WebKitFormBoundaryQ0phyISBKf0mXa15
Content-Disposition: form-data; name="photo"; filename="lulu.jpg"
Content-Type: image/jpeg
....

------WebKitFormBoundaryQ0phyISBKf0mXa15--


 */

