package bitcamp.pms.controller;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.sql.Date;
import bitcamp.pms.domain.Project;
import bitcamp.pms.annotation.Component;

@Component("project")
public class ProjectController implements MenuController {
  static final String filename = "project.data";
  Scanner keyScan;
  ArrayList<Project> projects;

  public ProjectController ( ) {
    projects = new ArrayList<>();
  }

  @Override
  public void init () {
    try{
    FileReader in0 = new FileReader(filename);
    BufferedReader in = new BufferedReader(in0);

    String line;
    String[] values;
    Project project;
    while((line = in.readLine())!=null) {
      values = line.split(",");
      project = new Project(values[0], Date.valueOf(values[1]), Date.valueOf(values[2]));
      project.setDescription(values[3]);
      project.setState(Integer.parseInt(values[4]));
      projects.add(project);
    }
    in.close();
    in0.close();
  }catch(Exception e) {
    System.out.println("데이터 로딩 실패");
  }
  }
  @Override
  public void destroy() {
    try{
    FileWriter out0 = new FileWriter(filename);
    BufferedWriter out1 = new BufferedWriter(out0);
    PrintWriter out = new PrintWriter(out1);


    for (Project project : projects){
      out.println(project);
    }


    out.close();
    out1.close();
    out0.close();
  } catch(Exception e) {
    System.out.println("데이터 저장 실패");
  }
  }




public String prompt() {
    System.out.print("프로젝트관리> ");
    return keyScan.nextLine().toLowerCase();
  }
  @Override
  public void service(Map<String,Object> paramMap) {
    keyScan = (Scanner)paramMap.get("stdin");
    String input="";
    while (!input.equals("main")) {
      try {
    input = prompt();
    if(input.equals("add")) {
      doAdd();
    } else if(input.equals("update")) {
      doUpdate();
    } else if (input.equals("delete")) {
      doDelete();
    } else if (input.equals("list")) {
      doList();
    } else if(input.equals("main")){
    } else {
      System.out.println("잘못된 명령입니다.");
    }
  } catch(IndexOutOfBoundsException e){
    System.out.println("유효한 인덱스가 아닙니다.");
  } catch (Exception e) {
    System.out.println("오류발생 !");
  }
  }
  }
  public void doAdd() {
     Project project = new Project();
     System.out.print("프로젝트명? ");
     project.setTitle(keyScan.nextLine());
     System.out.print("시작일? ");
     project.setStartDate(Date.valueOf(keyScan.nextLine()));
     System.out.print("종료일? ");
     project.setEndDate(Date.valueOf(keyScan.nextLine()));
     System.out.print("설명? ");
     project.setDescription(keyScan.nextLine());


     if (confirm("저장하시겠습니까")) {
       projects.add(project);
       System.out.println("저장되었습니다.");
     } else {
       System.out.println("저장이 취소되었습니다.");
     }

  }
    public void doUpdate() {
         Project project = new Project();
         System.out.print("변경하실 프로젝트 번호? ");
         int no = Integer.parseInt(keyScan.nextLine());
         System.out.printf("프로젝트명(%s)? ",projects.get(no).getTitle());
         project.setTitle(keyScan.nextLine());
         System.out.printf("시작일(%s)? ",projects.get(no).getStartDate());
        project.setStartDate(Date.valueOf(keyScan.nextLine()));
         System.out.printf("종료일(%s)? ",projects.get(no).getEndDate());
         project.setEndDate(Date.valueOf(keyScan.nextLine()));
         System.out.printf("설명(%s)? ",projects.get(no).getDescription());
         project.setDescription(keyScan.nextLine());


         if (confirm("변경하시겠습니까")) {
           projects.set(no,project);
           System.out.println("변경되었습니다.");
         } else {
           System.out.println("변경이 취소되었습니다.");
         }
    }
      public void doDelete() {
        System.out.print("삭제하실 프로젝트 번호? ");
        int no = Integer.parseInt(keyScan.nextLine());
        if (confirm("삭제하시겠습니까")) {
          projects.remove(no);
          System.out.println("삭제되었습니다.");
        } else {
          System.out.println("삭제가 취소되었습니다.");
        }
      }
        public void doList() {
            for(int i = 0; i < projects.size(); i++) {
              System.out.printf("%d, %s\n", i, projects.get(i).toString());
            }
        }

          public boolean confirm(String msg) {
            System.out.printf("%s (y/n)? ",msg);
            String input;
            while(true){

              input = keyScan.nextLine().toLowerCase();
              if(input.equals("y")) {
                return true;
              } else if(input.equals("n")) {
                return false;
              } else {
                System.out.print("다시 입력하세요. ");
              }

            }
          }









}
