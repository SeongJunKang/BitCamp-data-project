package bitcamp.pms0;

import java.util.Scanner;
import bitcamp.pms0.controller.MemberController;
// import bitcamp.pms0.controller.ProjectController;

public class ProjectApp {

  static Scanner scan = new Scanner(System.in);
  // ProjectController projectController = new ProjectController();
  static MemberController memberController = new MemberController();
  public static void main(String[] args) {
    try {
      memberController.load();
    } catch(Exception e) {
      System.out.println("생성된 데이터가 없습니다.");
    }

    String input;
    String[] cmds;
    do {
      System.out.print("명령 > ");
      input = scan.nextLine().toLowerCase();
      cmds = input.split(" ");
      switch(cmds[0]) {
        case "about" :
        System.out.println("about입니다.");
        break;
        case "quit" :
        doQuit();
        break;
        case "go" :
        doGo(cmds);
        break;
        default :
        System.out.println("잘못된 명령어 입니다.");
        break;
      }
    } while (!input.equals("quit"));
  }

  public static void doQuit() {
    memberController.save();
    System.out.println("프로그램을 종료합니다.");
  }
  public static void doGo(String[] cmds) {
    if(cmds.length < 2)  {
      System.out.println("메뉴 이름을 지정하세요.");
      System.out.println("예) go member");
      return;
    }
    switch(cmds[1]) {
      case "project" :
      // projectController.projectService();
      break;
      case "member" :
      memberController.memberService();
      break;
      default :
      System.out.println("없는 메뉴 입니다.");
    }
  }

}
