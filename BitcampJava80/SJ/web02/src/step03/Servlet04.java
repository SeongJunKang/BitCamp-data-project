// 출력하는 데이터의 형식을 HTTP 클라이언트에게 알려주기
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet04")
public class Servlet04 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("Servlet04");
    out.println("한글");
  }

}
/*
# ServletResponse.setContentType("MIME Type;문자집합")
- 응답 데이터의 형식과 문자집합을 클라이언트에게 알려준다.
- 즉 응답 헤더에 다음을 포함시킨다.
  ex) Content-Type : text/plain;charset=UTF-8
- 클라이언트는 응답 헤더 "Content-Type"의 값을 보고 어떻게 출력할 것인지 결정한다.
  HTML  -> 출력
  PDF   -> PDF 리더를 실행
  PPT   -> PowerPoint를 실행
  동영상-> 동영상 플레이어를 실행
  SWF   -> 플래시 플레이어를 실행
  기타  -> 다운로드 대화상자를 출력

# MIME(Multi-purpose Internet Mail Extensions) Type ?
- 메일 콘텐츠 형식을 지정하기 위해 등장.
- 지금은 여러 통신 프로토콜에서 콘텐츠의 형식을 지정하는데 사용하고 있다.
- 예)
  text/plain               => .txt
  text/html                => .html
  text/css                 => .css
  application/x-msvideo    => .avi
  image/gif                => .gif
  application/jason        => .json
  application/vnd.ms-excel => .xls
  application/xml          => .xml
  ...

# 로케일(Locale)
- 요청 및 응답할 때 사용할 언어와 국가를 표시하는 것
- 언어 코드
[ISO 639-1]/[ISO 639-2]
[en]       /[eng]
[fr]       /[fre]
[jp]       /[jpa]
[ko]       /[kor]

- 국가 코드
us/usa    (UNITED STATES)
gb/gbr    (UNITED KINGDOM)
kr/kor    (KOREA, REPUBLIC OF )
kp/prk    (KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF)
jp/jpn    (JAPAN)

- 로케일 표현 : 언어-국가
예)
en-US , en-GB , ko-KR, ja-JP

 */