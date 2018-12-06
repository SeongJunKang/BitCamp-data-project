package bitcamp.ems.servlet;

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

import bitcamp.ems.context.request.RequestHandler;
import bitcamp.ems.context.request.RequestHandlerMapping;
import bitcamp.ems.util.Session;

public class ProjectServlet implements Servlet {
  ServletConfig config;
  ApplicationContext appContext;
  RequestHandlerMapping requestHandlerMapping;
  Session session = new Session();
  @Override
  public void init(ServletConfig config) throws ServletException {
    appContext = new ClassPathXmlApplicationContext("conf/application-context.xml");
    requestHandlerMapping = new RequestHandlerMapping(appContext);
    this.config = config;
  }

  @Override
  public ServletConfig getServletConfig() {
    return config;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) 
      throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) req;
    String servletPath = request.getServletPath();
    RequestHandler requestHandler 
    = (RequestHandler) requestHandlerMapping.getRequestHandler(servletPath);
    if (requestHandler == null) {
      System.out.println("명령어를 처리할 객체가 없습니다.");
      return;
    }
    Method method = requestHandler.getMethod();
    try {
      ArrayList<Object> args = new ArrayList<>();
      Object arg = null;
      
      Map<String,String[]> originalParamMap =  request.getParameterMap();
      HashMap<String,String> paramMap = new HashMap<>();
      Set<Entry<String,String[]>> entrySet = originalParamMap.entrySet();
      for (Entry<String,String[]> entry : entrySet) {
        paramMap.put(entry.getKey(), entry.getValue()[0]);
      }
      for (Parameter param : method.getParameters()) {
        if (param.getType() == Session.class) {
          arg = session;
        } else if (param.getType() == Map.class) {
          arg = paramMap;
        } else if (param.getType() == PrintWriter.class) {
          res.setContentType("text/plain;charset=UTF-8");
          arg = res.getWriter();
        } else {
          arg = appContext.getBean(param.getType());
        }
        args.add(arg);
      }
      method.invoke(requestHandler.getObj(), args.toArray());
    } catch (Exception e) {
      System.out.println("명령 처리 중에 오류가 발생했습니다!");
    }
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return "Project Servlet!";
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stubs
    System.out.println("destroy()...");
  }

}

/*
 * 웹 애플리케이션 배포 1) 서블릿 컨테이너에서 지정한 위치에서 웹 애플리케이션 디렉토리를 생성한다. 
 * => $톰캣서버/webapps/pms
 * 2) 서블릿 클래스를 둘 디렉토리 생성 - 대소문자 구분 
 * => [웹애플리케이션디렉토리]/WEB-INF/classes 
 * 3) 서블릿 클래스를저장한다. 
 * => pms/WEB-INF/classes/bitcamp/pms/servlet/ProjectServlet.class 
 * 4) 웹 애플리케이션 설정 파일을 생성한다. 
 * => pms/WEB-INF/web.xml 
 * 5) 웹 애플리케이션 설정 파일에 서블릿 정보를 등록한다.
 * => 톰캣서버에 존재하는 예제 웹 애플리케이션을 참조하여 web.xml 파일 편집 
 * 6) 톰캣서버를 재시작하고, 웹 브라우저로 테스트 하라.
 * 
 * 7) 의존 라이브러리 파일을 웹 애플리케이션 디렉토리에 두어라. 
 * => pms/WEB-INF/lib/*.jar => gradle build를
 * 수행하면 배포 파일을 build라는 디렉토리에 준비한다. 
 * => $프로젝트/build 디렉토리에 있는 .jar 파일을 찾아 웹 애플리케이션
 * 디렉토리에 복사하라.
 */
