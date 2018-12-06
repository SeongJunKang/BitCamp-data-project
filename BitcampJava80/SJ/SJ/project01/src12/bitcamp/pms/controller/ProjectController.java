package bitcamp.pms.controller;

import java.util.Scanner;
import bitcamp.pms.domain.Project;
import java.sql.Date;

public class ProjectController {

  private Scanner keyScan = new Scanner(System.in);
  private Project[] projects = new Project[1000];
  private int count = 0;

  public void projectService() {
    System.out.println("--------------프로젝트관리에 오신걸 환영합니다.-------------");
    String input = null;
    do {
      input = projectprompt();
      projectService(input);
    } while (!input.equals("main"));
  }

  public void setScanner(Scanner keyScan) {
    this.keyScan = keyScan;
  }

  private String projectprompt() {
    System.out.print("프로젝트 관리 > ");
    return keyScan.nextLine().toLowerCase();
  }

  private void projectService(String input) {

    if (input.equals("add")) {
      doAdd();
    } else if (input.equals("update")) {
      doUpdate();
    } else if (input.equals("list")) {
      doList();
    } else if (input.equals("delete")) {
      doDelete();
    } else if (input.equals("main")) {
      doMain();
    } else{
      doError();
    }
  }


  private void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  private void doAdd() {
    Project project = new Project();

    System.out.print("프로젝트명  ? ");
    project.setTitle(keyScan.nextLine());

    System.out.print("시작일 ?(yyyy-mm-dd) ");
    project.setStartDate(Date.valueOf(keyScan.nextLine()));

    System.out.print("종료일 ?(yyyy-mm-dd) ");
    project.setEndDate(Date.valueOf(keyScan.nextLine()));

    System.out.print("설명 ? ");
    project.setDescription(keyScan.nextLine());

    System.out.print("상태 ( 숫자로 입력 )? ");
    project.setState(Integer.parseInt(keyScan.nextLine()));


    if (confirm("저장하시겠습니까?", true)) {
      projects[count++] = project;
      System.out.println("저장하였습니다.");
    } else {
      System.out.println("저장을 취소하였습니다.");
    }
  }

  private void doUpdate() {
    Project project = new Project();
    System.out.print("변경할 프로젝트 번호 입력 ? ");
    int no = Integer.parseInt(keyScan.nextLine());

    System.out.printf("제목(%s)? ", projects[no].getTitle());
    project.setTitle(keyScan.nextLine());

    System.out.printf("시작일(%s)? ", projects[no].getStartDate());
    project.setStartDate(Date.valueOf(keyScan.nextLine()));

    System.out.printf("종료일(%s)? ", projects[no].getEndDate());
    project.setEndDate(Date.valueOf(keyScan.nextLine()));

    System.out.printf("설명(%s)? ", projects[no].getDescription());
    project.setDescription(keyScan.nextLine());

    System.out.printf("상태(%s) 숫자만입력.? ", projects[no].getState());
    project.setState(keyScan.nextInt());

    if (confirm("변경하시겠습니까?", true)) {
      projects[no] = project;
      System.out.println("변경하였습니다.");
    } else {
      System.out.println("변경을 취소하였습니다.");
    }
  }

  private void doList() {
    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s\n", i,
        (projects[i] != null) ? projects[i].toString() : "");
    }
  }
  private void doMain() {
    System.out.println("--------------메인화면 입니다.-------------------");
  }

  private void doDelete() {
    System.out.print("삭제할 프로젝트 번호는? ");
    int no = Integer.parseInt(keyScan.nextLine());

    if (confirm("정말 삭제하시겠습니까?", true)) {
      projects[no] = null;
      for (int i = no + 1; i < count; i++) {
        projects[i-1] = projects[i];
      }
      count--;
      System.out.println("삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }

    private boolean confirm(String message, boolean strictMode) {
      String input = null;
      do {
        System.out.printf("%s(y/n) ", message);
        input = keyScan.nextLine().toLowerCase();

        if (input.equals("y")) {
          return true;
        } else if (input.equals("n")) {
          return false;
        } else {
          if (!strictMode) {
            return false;
          }
          System.out.println("잘못된 명령어입니다.");
        }
      } while(true);
    }
}
