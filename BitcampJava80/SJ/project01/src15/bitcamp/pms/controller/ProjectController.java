package bitcamp.pms.controller;

import java.util.Scanner;
import java.util.ArrayList;
import bitcamp.pms.domain.Project;
import java.sql.Date;
import java.util.Map;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;


public class ProjectController implements MenuController {
  private static final String filename = "project.data";
  private Scanner keyScan ;
  private ArrayList<Project> projects ;

  public ProjectController() {
    projects = new ArrayList<Project>();
  }
  public void load() {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);
      String text;
      String[] values;
      Project project;
      while ( (text = in.readLine()) != (null) ) {
        values = text.split(",");
        project = new Project(values[0],Date.valueOf(values[1]),Date.valueOf(values[2]));
        project.setDescription(values[3]);
        project.setState(Integer.parseInt(values[4]));
        projects.add(project);
      }
      in.close();
      in0.close();
    } catch (Exception e){
    }
  }
  @Override
  public String toString() {
    return "project";
  }


  public void save() throws Exception {
    FileWriter out0 = new FileWriter(filename);
    BufferedWriter out1 = new BufferedWriter(out0);
    PrintWriter out = new PrintWriter(out1);

    for (Project project : projects ) {
      out.println(project);
    }

    out.close();
    out1.close();
    out0.close();
  }

  @Override
  public void destroy() {
    try {
      this.save();
    } catch(Exception e){}
  }

  @Override
  public void init() {
    this.load();
  }

  @Override
  public void service(Map<String,Object> paramMap) {
    System.out.println("--------------프로젝트관리에 오신걸 환영합니다.-------------");
    keyScan = (Scanner)paramMap.get("stdin");
    String input = null;
    try {
      do {
        input = prompt();
        projectAct(input);
      } while (!input.equals("main"));
    } catch (Exception e) {}
  }

  private String prompt() {
    System.out.print("프로젝트 관리 > ");
    return keyScan.nextLine().toLowerCase();
  }

  private void projectAct(String input) {
    try{
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
    } catch (NumberFormatException e) {
      System.out.println("숫자만 입력해야합니다. ");
    } catch (IndexOutOfBoundsException e) {
        System.out.println("인덱스 유효범위를 벗어났습니다.");
    } catch (IllegalArgumentException e) {
      System.out.println("날짜 형식이 맞지 않습니다");
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
      projects.add(project);
      System.out.println("저장하였습니다.");
    } else {
      System.out.println("저장을 취소하였습니다.");
    }
  }

  private void doUpdate() {

    System.out.print("변경할 프로젝트 번호 입력 ? ");
    int no = Integer.parseInt(keyScan.nextLine());
    if( no >= projects.size() || no < 0) {
      doCheckNo();
      return;
    } else {
        Project project = new Project();
        System.out.printf("제목(%s)? ", projects.get(no).getTitle());
        project.setTitle(keyScan.nextLine());
        System.out.printf("시작일(%s)? ", projects.get(no).getStartDate());
        project.setStartDate(Date.valueOf(keyScan.nextLine()));

        System.out.printf("종료일(%s)? ", projects.get(no).getEndDate());
        project.setEndDate(Date.valueOf(keyScan.nextLine()));
        System.out.printf("설명(%s)? ", projects.get(no).getDescription());
        project.setDescription(keyScan.nextLine());
        System.out.printf("상태(%s) 숫자만입력.? ", projects.get(no).getState());
        project.setState(Integer.parseInt(keyScan.nextLine()));
        if (confirm("변경하시겠습니까?", true)) {
          projects.set(no,project);
          System.out.println("변경하였습니다.");
        } else {
          System.out.println("변경을 취소하였습니다.");
      }
    }
  }

  private void doList() {
    for (int i = 0; i < projects.size(); i++) {
      System.out.println( i  + "  " + projects.get(i));
    }
  }
  private void doMain() {
    System.out.println("--------------메인화면 입니다.-------------------");
  }

  private void doDelete() {
    System.out.print("삭제할 프로젝트 번호는? ");
    int no = Integer.parseInt(keyScan.nextLine());
    if( no >= projects.size() || no < 0) {
      doCheckNo();
      return;
    } else {
      if (confirm("정말 삭제하시겠습니까?", true)) {
        projects.remove(no);
        System.out.println("삭제하였습니다.");
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
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

  private void doCheckNo() {
    if (projects.size() != 0) {
      System.out.printf("프로젝트 번호가 잘못되었습니다. (0 ~ %d)\n", projects.size() - 1);
    } else {
      System.out.println("등록된 프로젝트가 없습니다.");
    }
  }

}
