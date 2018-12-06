package bitcamp.pms.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.ProjectDao;
import bitcamp.pms.domain.Project;
import bitcamp.pms.util.CommandUtil;

@Controller 
@RequestMapping("project/")
public class ProjectController {

    ProjectDao projectdao;
  
  public void setProjectdao(ProjectDao projectdao) {
      this.projectdao = projectdao;
    }

  @RequestMapping("add.do")
  public void add(Scanner keyScan) {
    Project project = new Project();
    System.out.printf("프로젝트명? ");
    project.setTitle(keyScan.nextLine());
    System.out.printf("시작일? ");
    project.setStartDate(Date.valueOf(keyScan.nextLine()));
    System.out.printf("종료일? ");
    project.setEndDate(Date.valueOf(keyScan.nextLine()));
    System.out.printf("설명? ");
    project.setDescription(keyScan.nextLine());
    
    if (CommandUtil.confirm("저장하시겠습니까", keyScan) ) {
      projectdao.insert(project);
      System.out.println("저장되었습니다.");
    } else  {
      System.out.println("저장이 취소되었습니다.");
    }
  }
  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    System.out.print("변경할 프로젝트 번호는?");
    int no = Integer.parseInt(keyScan.nextLine());
    
    Project oldProject = projectdao.selectOne(no);
    Project project = new Project();
    System.out.printf("프로젝트명 (%s)? ", oldProject.getTitle());
    project.setTitle(keyScan.nextLine());
    System.out.printf("시작일 (%s)? ", oldProject.getStartDate());
    project.setStartDate(Date.valueOf(keyScan.nextLine()));
    System.out.printf("종료일 (%s)? ", oldProject.getEndDate());
    project.setEndDate(Date.valueOf(keyScan.nextLine()));
    System.out.printf("설명 (%s)? ", oldProject.getDescription());
    project.setDescription(keyScan.nextLine());
    
    if (CommandUtil.confirm("변경하시겠습니까", keyScan) ) {
      projectdao.update(no, project);
      System.out.println("변경되었습니다.");
    } else  {
      System.out.println("변경이 취소되었습니다.");
    }
  }
  
  @RequestMapping("delete.do")
  public void delete (Scanner keyScan) {
    System.out.print("삭제할 프로젝트 번호는?");
    int no = Integer.parseInt(keyScan.nextLine());
        
    if (CommandUtil.confirm("삭제하시겠습니까", keyScan) ) {
      projectdao.delete(no);
      System.out.println("삭제되었습니다.");
    } else  {
      System.out.println("삭제가 취소되었습니다.");
    }
  }
  
  @RequestMapping("list.do")
  public void list() {
    ArrayList<Project> projects = new ArrayList<>();
    projects = projectdao.selectList();
    for (int i = 0 ; i < projects.size() ; i ++) {
      System.out.println(i +","+ projects.get(i).toString());
    }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}