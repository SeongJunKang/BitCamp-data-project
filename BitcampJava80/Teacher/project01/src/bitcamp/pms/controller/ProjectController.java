package bitcamp.pms.controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.ProjectDao;
import bitcamp.pms.domain.Project;

@Controller
@RequestMapping("/project/")
public class ProjectController {
  @Autowired
  private ProjectDao projectDao;

  @RequestMapping("add.do")
  public void add(Map<String,String> paramMap, PrintWriter out) {
    try {
      Project project = new Project();
      project.setTitle(paramMap.get("title"));
      project.setStartDate(Date.valueOf(paramMap.get("startDate")));
      project.setEndDate(Date.valueOf(paramMap.get("endDate")));
      project.setDescription(paramMap.get("description"));

      projectDao.insert(project);
      out.println("저장하였습니다.");
      
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    }
  }
   
  @RequestMapping("delete.do")
  public void delete(Map<String,String> paramMap, PrintWriter out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
      int count = projectDao.delete(no);
      
      if (count > 0) {
        out.println("삭제하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
      
    } catch (Exception e) {
      out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
  @RequestMapping("list.do")
  public void list(PrintWriter out) {
    try {
      List<Project> projects = projectDao.selectList();
      for (Project project : projects) {
        out.printf("%d, %s, %s, %s, %d\n", 
            project.getNo(),
            project.getTitle(),
            project.getStartDate(),
            project.getEndDate(),
            project.getState());
      }
    } catch (Exception e) {
      out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
  @RequestMapping("view.do")
  public void view(Map<String,String> paramMap, PrintWriter out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
      Project project = projectDao.selectOne(no);
      
      if (project == null) {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
        return;
      }
      
      out.printf("번호: %d\n", project.getNo());
      out.printf("프로젝트명: %s\n", project.getTitle());
      out.printf("기간: %s ~ %s\n", project.getStartDate(), project.getEndDate());
      out.printf("상태: %d\n", project.getState());
      out.println("내용:");
      out.println(project.getDescription());
      
    } catch (Exception e) {
      out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
  @RequestMapping("update.do")
  public void update(Map<String,String> paramMap, PrintWriter out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));

      Project project = projectDao.selectOne(no);
      if (project == null) {
        out.println("유효하지 않은 번호입니다.");
        return;
      }
      project.setTitle(paramMap.get("title"));
      project.setStartDate(Date.valueOf(paramMap.get("startDate")));
      project.setEndDate(Date.valueOf(paramMap.get("endDate")));
      project.setDescription(paramMap.get("description"));
      project.setState(Integer.parseInt(paramMap.get("state")));

      int count = projectDao.update(project);
      if (count > 0) {
        out.println("변경하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      out.println("데이터 로딩에 실패했습니다.");
    }
  }
}
