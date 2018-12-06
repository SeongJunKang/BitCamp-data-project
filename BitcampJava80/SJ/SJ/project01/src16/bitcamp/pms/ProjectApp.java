package bitcamp.pms;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.context.ApplicationContext;
import bitcamp.pms.context.request.RequestHandler;
import bitcamp.pms.context.request.RequestHandlerMapping;
import bitcamp.pms.controller.AuthController;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.util.CommandUtil;

public class ProjectApp {

  static ApplicationContext appContext;
  static RequestHandlerMapping requestHandlerMapping;
  static Scanner keyScan = new Scanner(System.in);
  static MemberDao memberDao;
  static AuthController authController;


  public static void main(String[] args) {
    appContext = new ApplicationContext("bitcamp.pms");
    requestHandlerMapping = new RequestHandlerMapping(appContext);
    appContext.addBean("stdinScan", keyScan);
    try {
      InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
      appContext.addBean("sqlSessionFactory", new SqlSessionFactoryBuilder().build(inputStream));
      memberDao = new MemberDao();
      memberDao.setSqlSessionFactory((SqlSessionFactory) appContext.getBean("sqlSessionFactory"));
    } catch (Exception e) {
      System.out.println("mybatis 준비 중 오류 발생!\n시스템을 종료하겠습니다.");
      return;
    }
    authController = (AuthController)appContext.getBean(AuthController.class);
    authController.service();

    String input;
    do {
      input = commandPrompt();
      processCommand(input);
      if (memberDao.selectOne(authController.getEmail()) == null) {
        return;
      }
    } while (!input.equals("quit"));
    keyScan.close();
  }

 

  static void processCommand(String input) {
    if(input.equals("quit")) {
      doQuit();
    } else if (input.equals("about")) {
      doAbout();
    } else if (input.equals("unsubscribe")) {
      doUnSubscribe();
    } else {
      RequestHandler requestHandler = (RequestHandler) requestHandlerMapping.getRequestHandler(input);
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

  static String commandPrompt() {
    System.out.print("명령> ");
    return keyScan.nextLine().toLowerCase();
  }
  


  public static void doQuit() {
    System.out.println("안녕히 가세요!");
  }

  public static void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  static void doAbout() {
    System.out.println("비트캠프 80기 프로젝트 관리 시스템!");
  }

  static void doUnSubscribe() {
    try {
      if (CommandUtil.confirm(keyScan, "정말 탈퇴하시겠습니까?")) {
        memberDao.delete(authController.getSelectedNo());
        System.out.println("탈퇴가 완료되었습니다. 안녕히가세요.");
      } else {
        System.out.println("탈퇴를 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }

}
