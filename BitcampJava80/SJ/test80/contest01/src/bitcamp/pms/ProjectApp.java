
package bitcamp.pms;

import java.util.Scanner;
import bitcamp.pms.controller.MemberController;
import bitcamp.pms.controller.ProjectController;

public class ProjectApp {
  static Scanner keyScan = new Scanner(System.in);
  static MemberController memberController = new MemberController();
  static ProjectController projectController = new ProjectController();
  public static void main(String[] args) {
    // 멤버 관리 객체 생성

    memberController.setScanner(keyScan); // <-- 의존 객체 주입
    projectController.setScanner(keyScan); // <-- 의존 객체 주입

    String input;
    String[] cmds;
    do {
      System.out.print("명령> ");
      input = keyScan.nextLine().toLowerCase();
      cmds = input.split(" ");

      switch(cmds[0]) {
        case "quit":
        doQuit();
        case "about":
        System.out.println("비트캠프 80기 프로젝트 관리 시스템!");
        break;
        case "go":
        doGo(cmds);
        default :
        System.out.println("올바르지 않은 명령어입니다.");
        break;
      }

    } while (!input.equals("quit"));
  }

  static void doQuit() {
    try {
      memberController.save();
      projectController.save();
      System.out.println("데이터를 저장했습니다.");

    } catch (Exception e) {
      System.out.println("데이터 저장에 실패했습니다!");
    }
    System.out.println("안녕히 가세요!");
  }

  static void doGo(String[] cmds) {
    if (cmds.length < 2) {
      System.out.println("메뉴 이름을 지정하세요.");
      System.out.println("예) go member");
      return;
    }
    switch (cmds[1]) {
      case "member":
        memberController.service();
        break;
      case "project":
        projectController.service();
        break;
      default:
        System.out.println("없는 메뉴입니다.");
    }
  }

}
