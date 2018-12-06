//주제 : 서블릿 만들고 배포하기
package step01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello2 extends GenericServlet{
  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    // TODO Auto-generated method stub
    System.out.println("Hello2 service()");
  }
 

}

/* 
# GenericServlet 추상 클래스
- Servlet 인터페이스를 미리 구현한 클래스
- Servlet 인터페이스를 구현하는 번거로움을 줄이는 용도
  즉 개발자가 직접 Servlet 인터페이스를 구현하는 것 보다
  GenericServlet를 상속하여 service()를 구현하는 것이 더 편리하다.
  
# GenericServlet 추상 클래스와 Serializable 인터페이스
- GenericServlet 클래스는 기본으로 Serializable 을 구현했기 떄문에,
  이 클래스를 상속하는 서브 클래스는 가능한 데이터의 시리얼 버전을 지정하라 !
  이유 ?
  deserialize하는 쪽에서 데이터의 버전을 확인하여 인스턴스 객체로 만들 때
  참고할 수 있도록 하기 위함이다.
- Serializable을 구현하는 클래스는 가능한 시리얼 버전(serialVersionUID)을 지정하라. 
*/
