package bitcamp.pms;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.context.ApplicationContext;
import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.context.request.RequestHandlerMapping;
import bitcamp.pms.controller.AuthController;
import bitcamp.pms.util.Session;

public class ProjectApp {

  ApplicationContext appContext;
  RequestHandlerMapping requestHandlerMapping;
  Scanner keyScan = new Scanner(System.in);
  Session session = new Session();
  AuthController authController;

  public void run() throws Exception {

    appContext = new ApplicationContext("bitcamp.pms");
    requestHandlerMapping = new RequestHandlerMapping(appContext);
    appContext.addBean("stdinScan", keyScan);
    appContext.addBean("session", session);

    try {
      InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
      appContext.addBean("sqlSessionFactory", new SqlSessionFactoryBuilder().build(inputStream));
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("mybatis 준비 중 오류 발생!\n시스템을 종료하겠습니다.");
      return;
    }
    authController = (AuthController) appContext.getBean(AuthController.class);
    authController.service();

    String input;
    do {
      input = commandPrompt();
      processCommand(input);
    } while (!input.equals("quit"));
    keyScan.close();
  }

  public static void main(String[] args) {
    ProjectApp projectApp = new ProjectApp();
    try {

      projectApp.run();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void processCommand(String input) {
    if (input.equals("quit")) {
      doQuit();
    } else if (input.equals("about")) {
      doAbout();
    } else {
      RequestHandler requestHandler = (RequestHandler) 
          requestHandlerMapping.getRequestHandler(input);
      if (requestHandler == null) {
        doError();
        return;
      }
      Method method = requestHandler.getMethod();
      try {
        ArrayList<Object> args = new ArrayList<>();
        Object arg = null;
        for (Parameter param : method.getParameters()) {
          arg = appContext.getBean(param.getType());
          args.add(arg);
        }
        method.invoke(requestHandler.getObj(), args.toArray());
      } catch (Exception e) {
        System.out.println("명령 처리 중에 오류가 발생했습니다!");
      }
    }
  }

  String commandPrompt() {
    System.out.print("명령> ");
    return keyScan.nextLine().toLowerCase();
  }

  public void doQuit() {
    System.out.println("안녕히 가세요!");
  }

  public void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  void doAbout() {
    System.out.println("비트캠프 80기 프로젝트 관리 시스템!");
  }

}
