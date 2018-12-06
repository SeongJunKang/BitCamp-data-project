/* 목표
/*
 *목표
 *- 커맨트 방식으로 작업을 처리하라.
 *
 *작업절차 
 *1)MemberController 를 다음 클래스로 분리한다
 *MemberListController ,MemberAddController ,MemberUpdateController
 * ,MemberDeleteController 
 */
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

public class ProjectApp {
  static ApplicationContext app;
  static RequestHandlerMapping requestHandlerMapping;
  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    app = new ApplicationContext("bitcamp.pms");
    requestHandlerMapping = new RequestHandlerMapping(app);
    app.addBean("stdinScan", keyScan);

    try {
      InputStream inputStream = Resources.getResourceAsStream(
          "conf/mybatis-config.xml");
      app.addBean("sqlSessionFactory", new SqlSessionFactoryBuilder()
          .build(inputStream));
    } catch (Exception e) {
      System.out.println("DB 로딩 오류.");
      e.printStackTrace();
      return;
    }

    String input;
    do {
      input = prompt();
      processCommand(input);
    } while (!input.equals("quit"));
    keyScan.close();
  }

  static void processCommand(String input) {

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
      Object obj = requestHandler.getObj();

      try {
        ArrayList<Object> args = new ArrayList<>();
        Parameter[] params = method.getParameters();
        Object arg = null;
        for (Parameter param : params) {
          arg = app.getBean(param.getType());
          args.add(arg);
        }
        method.invoke(obj, args.toArray());
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("명령처리중 오류발생!");
      }
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyScan.nextLine().toLowerCase();
  }

  static void doQuit() {
    System.out.println("안녕히 가세요!");
  }

  static void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  static void doAbout() {
    System.out.println("비트캠프 80기 프로젝트 관리 시스템!");
  }

}
