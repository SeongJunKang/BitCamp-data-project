//클라이언트가 보낸 파라미터 값 알아내기
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet05")
public class Servlet05 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    //파라미터값 알아내기
    // => http://localhost:8080/web02/step03/servlet05?name=aaa&email=bbb&tel=111
    // ServletRequest.getParameter(파라미터명);
    String name = req.getParameter("name");
    String email = req.getParameter("email");
    String tel = req.getParameter("tel");
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("이름 : %s | 이메일 : %s | 전화 : %s \n",name,email,tel);
    out.println("Servlet05");
    out.println("한글");
  }

}
/*
# URL에 포함된 한글 파라미터 값이 깨지는 이유
- 서블릿 컨테이너는 클라이언트가 보낸 데이터를 ISO-8859-1로 간주한다.
- 그래서 ISO-8859-1 ---> Unicode로 변환한다.
  여기서 문제가 발생한 것이다.
  예) 보내는 파라미터 값이 "ABC가각" 일 때,
  웹 브라우저는 UTF-8로 보낸다=> 41 42 43 EA B0 80 EA B0 81
  서블릿 컨테이너는 ISO-8859-1로 취급한다. 즉 1바이틈 문자로 취급.
  각 1바이트를 유ㅜ니코드로 바꾼다.
  => 영어는 1바이트에 00을 붙이면 된다.
  41 ==> 0041 (OK)
  42 ==> 0042 (OK)
  43 ==> 0043 (OK)
  => 한글은 3바이트를 묶어 유니코드 2바이트로 만들어야 한다.
  EA ==> 00EA (X)
  B0 ==> 00B0 (X)
  80 ==> 0080 (X)
  EA ==> 00EA (X)
  B0 ==> 00B0 (X)
  81 ==> 0081 (X)
  EA B0 80 => AC 00 (가)
  EA B0 81 => AC 01 (각)
  
- 해결책?
  톰캣 8.0은 자동으로 처리. 별도 설정 필요 없다.
  1)톰캣 7.0은 SERVER.XML 파일의 <CONNECT> 태그에 다음 속성을 추가하라!
  2)
 */
