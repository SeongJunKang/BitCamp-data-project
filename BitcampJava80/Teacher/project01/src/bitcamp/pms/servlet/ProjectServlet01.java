package bitcamp.pms.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ProjectServlet01 implements Servlet {
  ServletConfig config;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()...");
    this.config = config;
  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Hello");
    
  }

  @Override
  public String getServletInfo() {
    return "Project Servlet";
  }

  @Override
  public void destroy() {
    System.out.println("destroy()...");
  }

}

/*
# 웹 애플리케이션 배포
1) 서블릿 컨테이너에서 지정한 위치에 웹 애플리케이션 디렉토리를 생성한다.
  => $톰캣서버/webapps/pms
  
2) 서블릿 클래스를 둘 디렉토리 생성한다.
  => [웹애플리케이션디렉토리]/WEB-INF/classes
  
3) 서블릿 클래스를 저장한다.
  => pms/WEB-INF/classes/bitcamp/pms/servlet/ProjectServlet.class  

4) 웹 애플리케이션 설정 파일을 생성한다.
  => pmx/WEB-INF/web.xml

5) 웹 애플리케이션 설정 파일에 서블릿 정보를 등록한다.
  => 톰캣서버에 존재하는 예제 웹 애플리케이션을 참조하여 web.xml 파일 편집하라. 
  
6) 톰캣서버를 재 시작하고, 웹 브라우저로 테스트를 하라!
 */















