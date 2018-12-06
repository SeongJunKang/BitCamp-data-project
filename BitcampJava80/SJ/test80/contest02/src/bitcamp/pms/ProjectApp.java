package bitcamp.pms;

import java.util.Scanner;
import bitcamp.pms.controller.MemberController;
import bitcamp.pms.controller.ProjectController;

public class ProjectApp {
  static Scanner scan = new Scanner(System.in);
  static MemberController member = new MemberController();
  static ProjectController project = new ProjectController();


  public static void main(String[] args){

    try {
      member.load();
      project.load();
    } catch(Exception e){

    }

    String input= null;
    String[] cmds;
    do {
      input = prompt();
      cmds = input.split(" ");
      switch(cmds[0]) {
        case "quit" :
        doQuit();
        break;
        case "about":
        doAbout();
        break;
        case "go":
        doGo(cmds);
        break;
        default :
        System.out.println("잘못된 명령어 입니다.");
        break;
      }
    } while (!input.equals("quit"));

  }


  static void doAbout() {
    System.out.println("비트캠프 80기 관리 프로그램");
  }

  static String prompt() {
    System.out.print("명령> ");
    return scan.nextLine().toLowerCase();
  }

  static void doQuit() {
    try {
      member.save();
      project.save();
      System.out.println("데이터를 저장했습니다.");
    } catch(Exception e) {
      System.out.println("데이터 저장을 취소했습니다.");
    }
    System.out.println("안녕히 가세요.");
  }

  static void doGo(String[] cmds) {
    if (cmds.length < 2) {
      System.out.println("올바른 메뉴를 지정하세요.");
      System.out.println("예) go member");
      return;
    }

    switch (cmds[1]) {
      case "member":
      member.service();
      break;
      case "project":
      project.service();
      break;
      default :
      System.out.println("없는 메뉴입니다.");
      break;
    }
  }

}
