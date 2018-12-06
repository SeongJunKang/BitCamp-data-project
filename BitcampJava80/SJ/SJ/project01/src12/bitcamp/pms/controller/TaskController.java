// 6) 프로젝트의 작업 정보를 다루는 클래스를 추가한다.
//   => bitcamp.pms.domain.Task 클래스 추가
//     - title:String
//     - description:String
//     - memberNo:int
//     - projectNo:int
//     - state:int
//   => bitcamp.pms.controller.TaskController 클래스 추가
//   => "go task" 명령을 처리할 수 있도록 ProjectApp 클래스를 변경


package bitcamp.pms.controller;
import bitcamp.pms.domain.Task;
import java.util.Scanner;

public class TaskController {

  private Scanner keyScan = new Scanner(System.in);
  private Task[] tasks = new Task[1000];
  private int count = 0;

  public void taskService() {
    System.out.println("---------------- Task에 오신것을 환영합니다.---------------");
    String input ;
    do {
      input = taskPrompt();
    } while(!input.equals("main"));
  }

  public void setScanner(Scanner keyScan) {
    this.keyScan = keyScan;
  }

  public void processTask(String input) {

    switch(input.toLowerCase()) {
      case "add" :
      // doAdd();
      break;
      case "update" :
      // doUpdate();
      break;
      case "list" :
      doList();
      break;
      case "delete" :
      // doDelete();
      break;
      case "main" :
      doMain();
      break;
      default :
      doError();
      break;

    }
  }

  private void doMain() {
    System.out.println("----------------메인화면 입니다.--------------");
  }


  private void doList() {
    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s\n", i,
        (tasks[i] != null) ? tasks[i].toString() : "");
    }
  }

  private void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  public String taskPrompt() {
    System.out.print("Task > ");
    return keyScan.nextLine().toLowerCase();
  }

}
