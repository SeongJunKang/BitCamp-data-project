//package bitcamp.pms.controller;
//
//import java.sql.Date;
//import java.util.List;
//import java.util.Scanner;
//
//import bitcamp.pms.annotation.Controller;
//import bitcamp.pms.annotation.RequestMapping;
//import bitcamp.pms.dao.ProjectDao;
//import bitcamp.pms.domain.Project;
//import bitcamp.pms.util.CommandUtil;
//
//@Controller
//@RequestMapping("project/")
//public class ProjectController {
//
//  private ProjectDao projectDao;
//
//  public void setProjectDao(ProjectDao projectDao) {
//    this.projectDao = projectDao;
//  }
//
//  @RequestMapping("add.do")
//  public void add(Scanner keyScan) {
//    Project project = new Project();
//    System.out.print("프로젝트명  ? ");
//    project.setTitle(keyScan.nextLine());
//    System.out.print("시작일 ?(yyyy-mm-dd) ");
//    project.setStartDate(Date.valueOf(keyScan.nextLine()));
//    System.out.print("종료일 ?(yyyy-mm-dd) ");
//    project.setEndDate(Date.valueOf(keyScan.nextLine()));
//    System.out.print("설명 ? ");
//    project.setDescription(keyScan.nextLine());
//
//    if (CommandUtil.confirm("저장하시겠습니까?", keyScan)) {
//      try {
//        projectDao.insert(project);
//        System.out.println("저장하였습니다.");
//      } catch (Exception e) {
//        System.out.println("데이터 저장에 실패했습니다.");
//      }
//    } else {
//      System.out.println("저장을 취소하였습니다.");
//    }
//
//  }
//
//  @RequestMapping("delete.do")
//  public void delete(Scanner keyScan) {
//    try {
//
//      System.out.print("삭제할 프로젝트 번호는? ");
//      int no = Integer.parseInt(keyScan.nextLine());
//      if (CommandUtil.confirm("정말 삭제하시겠습니까?", keyScan)) {
//        if (projectDao.delete(no) > 0) {
//          System.out.println("삭제하였습니다.");
//        } else {
//          System.out.println("유효하지 않은 인덱스 이거나 이미 삭제된 항목입니다.");
//        }
//      } else {
//        System.out.println("삭제를 취소하였습니다.");
//      }
//    } catch (Exception e) {
//      System.out.println("유효한 인덱스가 아닙니다.");
//    }
//  }
//
//  @RequestMapping("list.do")
//  public void list(Scanner keyScan) {
//    try {
//      List<Project> projects = projectDao.selectList();
//      for (int i = 0; i < projects.size(); i++) {
//        System.out.println(projects.get(i));
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//      System.out.println("프로젝트 list 불러오기 실패");
//    }
//  }
//
//  @RequestMapping("update.do")
//  public void update(Scanner keyScan) {
//    try {
//      System.out.print("변경할 프로젝트 번호 입력 ? ");
//      int no = Integer.parseInt(keyScan.nextLine());
//      Project project = projectDao.selectOne(no);
//      if (project == null) {
//        System.out.println("유효하지 않은 인덱스 이거나 이미 삭제된 항목입니다.");
//        return;
//      }
//      System.out.printf("제목(%s)? ", project.getTitle());
//      project.setTitle(keyScan.nextLine());
//      System.out.printf("시작일(%s)? ", project.getStartDate());
//      project.setStartDate(Date.valueOf(keyScan.nextLine()));
//      System.out.printf("종료일(%s)? ", project.getEndDate());
//      project.setEndDate(Date.valueOf(keyScan.nextLine()));
//      System.out.printf("설명(%s)? ", project.getDescription());
//      project.setDescription(keyScan.nextLine());
//      if (CommandUtil.confirm("변경하시겠습니까?", keyScan)) {
//        if (projectDao.update(project) > 0) {
//          System.out.println("변경하였습니다.");
//        }
//      } else {
//        System.out.println("변경을 취소하였습니다.");
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//      System.out.println("오류.");
//    }
//
//  }
//
//}
