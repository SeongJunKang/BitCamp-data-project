package bitcamp.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.context.request.RequestHandlerMapping;
import bitcamp.pms.util.Session;

public class ProjectServlet implements Servlet {
  ServletConfig config;
  ApplicationContext appContext;
  RequestHandlerMapping requestHandlerMapping;
  Session session = new Session();
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()...");
    this.config = config;
    
    appContext = new ClassPathXmlApplicationContext(
        "conf/application-context.xml");
    requestHandlerMapping = new RequestHandlerMapping(appContext);
  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    HttpServletRequest req = (HttpServletRequest)request;
    
    // URL에서 서블릿 경로를 추출한다.
    // 예) http://localhost:8080/pms/member/list.do?pageNo=1&pageSize=10&pageNo=20
    // protocol => http
    // 서버 주소 및 포트번호 => localhost:8080
    // 웹 애플리케이션 경로 => /pms
    // 서블릿 경로 => /member/list.do
    // 파라미터 => pageNo=1&pageSize=10
    String servletPath = req.getServletPath(); // 리턴 값: /member/list.do
    
    // "/member/list.do" 명령을 처리할 메서드 정보를 꺼낸다.
    RequestHandler requestHandler = 
        requestHandlerMapping.getRequestHandler(servletPath);
    
    if (requestHandler == null) { // 명령 처리기를 못 찾았다면,
      System.out.println("명령어를 처리할 객체가 없습니다.");
      return;
    }
    
    // 찾았다면, 메서드와 인스턴스를 꺼낸다.
    Method method = requestHandler.getMethod();
    Object obj = requestHandler.getObj();
    
    // 메서드에 넘길 파라미터 값을 준비한다.
    try {
      ArrayList<Object> args = new ArrayList<>();
      Parameter[] params = method.getParameters();
      Object arg = null;
      
      // 서블릿에서 준비한 파라미터 맵을 
      // 컨트롤러가 원하는 형식으로 바꾼다.
      Map<String,String[]> originalParamMap = request.getParameterMap();
      HashMap<String,String> paramMap = new HashMap<>();
      Set<Entry<String,String[]>> entrySet = originalParamMap.entrySet();
      for (Entry<String,String[]> entry : entrySet) {
        paramMap.put(entry.getKey(), entry.getValue()[0]);
      }
      
      for (Parameter param : params) {
        if (param.getType() == Session.class) {
          arg = session;
        } else if (param.getType() == Map.class) {
          arg = paramMap;
        } else if (param.getType() == PrintWriter.class) {
          // 웹 브라우저에게 보낼 데이터가 어떤 형식인지 지정한다.
          response.setContentType("text/plain;charset=UTF-8");  
          arg = response.getWriter();
        } else {
          arg = appContext.getBean(param.getType());
        }
        args.add(arg);
      }
      
      method.invoke(obj, args.toArray());
      
    } catch (Exception e) {
      System.out.println("명령 처리 중에 오류가 발생했습니다!");
      e.printStackTrace();
    }
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

7) 의존 라이브러리 파일을 웹 애플리케이션 디렉토리에 두어라.
  => pms/WEB-INF/lib/*.jar
  => gradle build를 수행하면 배포 파일을 build라는 디렉토리에 준비한다.
  => $프로젝트/build 디렉토에 있는 .jar 파일을 찾아 웹 애플리케이션 디렉토리에 복사하라.
 */















