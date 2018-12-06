package bitcamp.pms;

import java.util.*;
import bitcamp.pms.controller.MenuController;
import bitcamp.pms.context.ApplicationContext;

public class ProjectApp {

  static ApplicationContext app;
  static Scanner keyScan = new Scanner(System.in);
  public static void main(String[] args) {
    app = new ApplicationContext("bitcamp.pms.controller");

    Collection<Object> controllers = app.getBeans(MenuController.class);

    for(Object controller : controllers) {
      ((MenuController)controller).init();
    }


    String input;

    do {
      input = prompt();
      processCommand(input);
    } while (!input.equals("quit"));

    keyScan.close();

  }


static String prompt() {
  System.out.print("명령> ");
  return keyScan.nextLine().toLowerCase();
}

static void processCommand(String input) {
  String[] cmds = input.split(" ");
  if (cmds[0].equals("quit")) {
    doQuit();
  } else if(cmds[0].equals("about")) {
    doAbout();
  } else if(cmds[0].equals("go")) {
    doGo(cmds);
  } else if(cmds[0].equals("main")){

  }else {
    doError();
  }
  }

static void doAbout() {
  System.out.println("비트 캠프 자바80기 프로젝트");
}
static void doQuit() {
  Collection<Object> controllers = app.getBeans(MenuController.class);

  for(Object controller : controllers) {
    ((MenuController)controller).destroy();
  }
  System.out.println("안녕히가세요.");
}
static void doError() {
  System.out.println("잘못된 명령어 입니다.");
}
  static void doGo(String[] cmds) {
    if(cmds.length < 2) {
      System.out.println("메뉴를 지정하세요");
      System.out.println("예 ) go Member");
      return;
    }

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("stdin",keyScan);

    MenuController controller = (MenuController)app.getBean(cmds[1]);
    if(controller !=null) {
      controller.service(paramMap);
    } else {
      System.out.println("없는 메뉴입니다.");
    }

  }

}
