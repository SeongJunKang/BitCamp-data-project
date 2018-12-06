package bitcamp.pms.controller;

import java.util.Scanner;
import java.util.ArrayList;
import bitcamp.pms.domain.Project;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;

public class ProjectController {
  final static String filename = "Project.data";
  Scanner scan = new Scanner(System.in);
  ArrayList<Project> projects ;

  public  ProjectController() {
    projects = new ArrayList<>();
  }

  public void load() {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);

      String line;
      String[] values;
      Project project;
      while ((line = in.readLine()) != null){
        values = line.split(",");
        project = new Project(values[0],Date.valueOf(values[1]),Date.valueOf(values[2]));
        project.setState(Integer.parseInt(values[3]));
        project.setDescript(values[4]);
        projects.add(project);
      }
      in.close();
      in0.close();
    } catch (Exception e) {

    }
  }
  public void save() {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0);
      PrintWriter out = new PrintWriter(out1);

      for (Project project : projects) {
        out.println(project);
      }

      out.close();
      out1.close();
      out0.close();
    } catch (Exception e) {

    }

  }

  public void service() {

    String input = null;

    do {
      try{
        System.out.print("프로젝트관리> ");
        input = scan.nextLine().toLowerCase();
        switch (input) {
          case "add":
            doAdd(); break;
          case "update":
            doUpdate(); break;
          case "list":
            doList(); break;
          case "delete":
            doDelete(); break;
          case "main":
          break;
          default:
            System.out.println("잘못된 명령어입니다.");
        }
      } catch(IndexOutOfBoundsException e){
        System.out.println("유효하지 않은 인덱스 입니다.");
      } catch (IllegalArgumentException e) {
        System.out.println("잘못된 날짜 형식입니다.");
      } catch (Exception e) {
      }
    } while(!input.equals("main"));
  }

  public boolean confirm(String msg){
    while (true) {
      System.out.printf("%s (y/n) ",msg);
      String input= scan.nextLine().toLowerCase();
      if(input.equals("y")) {
        return true;
      } else if (input.equals("n")) {
        return false;
      } else {
        System.out.println("잘못 입력했습니다.");
      }
    }
  }

  public void doAdd() {
    Project project = new Project();

    System.out.printf("프로젝트명? ");
    project.setTitle(scan.nextLine());
    System.out.printf("시작일? ");
    project.setStartDate(Date.valueOf(scan.nextLine()));
    System.out.printf("종료일? ");
    project.setEndDate(Date.valueOf(scan.nextLine()));
    System.out.printf("설명? ");
    project.setDescript(scan.nextLine());
    // System.out.printf("상태 ? ");
    // project.setState(Integer.parseInt(scan.nextLine()));

    if (confirm("저장하시겠습니까? ")) {
      projects.add(project);
      System.out.println("저장했습니다.");
    } else {
      System.out.println("저장 취소했습니다.");
    }
  }
  public void doUpdate() {
    Project project = new Project();
    System.out.print("변경하실 프로젝트 번호? ");
    int no = Integer.parseInt(scan.nextLine());

    System.out.printf("프로젝트명(%s)? ",projects.get(no).getTitle());
    project.setTitle(scan.nextLine());
    System.out.printf("시작일(%s)? ",projects.get(no).getStartDate());
    project.setStartDate(Date.valueOf(scan.nextLine()));
    System.out.printf("종료일(%s)? ",projects.get(no).getEndDate());
    project.setEndDate(Date.valueOf(scan.nextLine()));
    System.out.printf("설명(%s)? ",projects.get(no).getDescript());
    project.setDescript(scan.nextLine());
    // System.out.printf("상태 (%s)? ",projects.get(no).getState());
    // project.setState(Integer.parseInt(scan.nextLine()));

    if (confirm("변경하시겠습니까? ")) {
      projects.set(no,project);
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }
  }

 public void doDelete() {
   System.out.print("삭제하실 프로젝트 번호? ");
   int no = Integer.parseInt(scan.nextLine());

   if (confirm("삭제하시겠습니까? ")) {
     projects.remove(no);
     System.out.println("삭제했습니다.");
   } else {
     System.out.println("삭제 취소했습니다.");
   }
 }

 public void doList() {
   for (int i = 0; i < projects.size(); i++) {
     System.out.printf("%d, %s\n", i, projects.get(i).toString());
   }
 }

}
