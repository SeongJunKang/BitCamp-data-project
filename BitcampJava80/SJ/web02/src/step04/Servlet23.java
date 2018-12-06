//서블릿 초기화 파라미터 다루기
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet23 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres) throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    httpreq.setCharacterEncoding("UTF-8");
    PrintWriter out = httpres.getWriter();
    
    // # 서블릿 초기화 파라미터 값 꺼내기
    // 1) 서블릿 설정 정보를 다루는 객체를 준비한다.
    ServletConfig config = this.getServletConfig();
    
    // 2) 초기화 파라미터 (init-param)  값 출력
    out.printf("테스트1 = %s \n",config.getInitParameter("테스트1"));
    out.printf("테스트2 = %s \n",config.getInitParameter("테스트2"));
    out.printf("테스트3 = %s \n",config.getInitParameter("테스트3"));
    
    out.println("============================================");
    // # 서블릿 컨텍스트 파라미터 값 꺼내기
    ServletContext context = this.getServletContext();
    out.printf("center = %s \n",context.getInitParameter("center"));
    out.printf("class = %s \n",context.getInitParameter("class"));
  }
}

/* 
# 서블릿 초기화 파라미터
- DD 파일에 설정된 파라미터
- 예)
  <servlet>
    <init-param>
      <param-name>파라미터명</param-name>
      <param-value>파라미터값</param-value>
    </init-param>
    <init-param>
      <param-name>파라미터명2</param-name>
      <param-value>파라미터값2</param-value>
    </init-param>
    ....
  </servlet>
  
  
# 서블릿 컨텍스트 파라미터
- 모든 서블릿들이 참조할 수 있는 파라미터
- 예)
  <context-param>
      <param-name>파라미터명</param-name>
      <param-value>파라미터값</param-value>
  </context-param>
  
# 필터 초기화 파라미터
- DD 파일에 선언된 파라미터
- 파라미터가 선언된 필터만이 사용할 수 있다.
- 설정하는 방법은 서블릿 초기화 파라미터와 같다.
- CharacterEncodingFilter.java 참조.
 */

