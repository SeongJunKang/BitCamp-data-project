package bitcamp.pms.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.TaskDao;
import bitcamp.pms.domain.Task;
import bitcamp.pms.util.CommandUtil;

@Controller
@RequestMapping("task/")
public class TaskController {
  @Autowired
  private TaskDao taskDao;

  @RequestMapping("add.do")
  public void add(Scanner keyScan) {
    Task task = new Task();
    System.out.print("작업명 ? ");
    task.setTitle(keyScan.nextLine());
    System.out.print("작업자 이메일 ? ");
    task.setWorkerEmail(keyScan.nextLine());
    System.out.print("내용 ? ");
    task.setContent(keyScan.nextLine());
    System.out.print("시작일 ?(yyyy-mm-dd) ");
    task.setStartDate(Date.valueOf(keyScan.nextLine()));
    System.out.print("종료일 ?(yyyy-mm-dd) ");
    task.setEndDate(Date.valueOf(keyScan.nextLine()));

    if (CommandUtil.confirm(keyScan,"저장하시겠습니까?")) {
      try {
        taskDao.insert(task);
        System.out.println("저장하였습니다.");
      } catch (Exception e) {
        System.out.println("데이터 저장에 실패했습니다.");
      }
    } else {
      System.out.println("저장을 취소하였습니다.");
    }

  }

  @RequestMapping("delete.do")
  public void delete(Scanner keyScan) {
    try {

      System.out.print("삭제할 작업 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
      if (CommandUtil.confirm(keyScan,"정말 삭제하시겠습니까?")) {
        if (taskDao.delete(no) > 0) {
          System.out.println("삭제하였습니다.");
        } else {
          System.out.println("유효하지 않은 인덱스 이거나 이미 삭제된 항목입니다.");
        }
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("유효한 인덱스가 아닙니다.");
    }
  }

  @RequestMapping("list.do")
  public void list(Scanner keyScan) {
    try {
      List<Task> tasks = taskDao.selectList();
      for (int i = 0; i < tasks.size(); i++) {
        System.out.println(tasks.get(i));
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("TASK list 불러오기 실패");
    }
  }

  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    try {
      System.out.print("변경할 작 번호 입력 ? ");
      int no = Integer.parseInt(keyScan.nextLine());
      Task task = taskDao.selectOne(no);
      if (task == null) {
        System.out.println("유효하지 않은 인덱스 이거나 이미 삭제된 항목입니다.");
        return;
      }
      
      System.out.printf("작업명(%s)? ", task.getTitle());
      task.setTitle(keyScan.nextLine());
      System.out.printf("작업자 이메일(%s)? ",task.getWorkerEmail());
      task.setWorkerEmail(keyScan.nextLine());
      System.out.printf("내용(%s)? ", task.getContent());
      task.setContent(keyScan.nextLine());
      System.out.printf("시작일(%s)? ", task.getStartDate());
      task.setStartDate(Date.valueOf(keyScan.nextLine()));
      System.out.printf("종료일(%s)? ", task.getEndDate());
      task.setEndDate(Date.valueOf(keyScan.nextLine()));
      
      if (CommandUtil.confirm(keyScan,"변경하시겠습니까?")) {
        if (taskDao.update(task) > 0) {
          System.out.println("변경하였습니다.");
        }
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("유효한 인덱스가 아닙니다.");
    }

  }

}
