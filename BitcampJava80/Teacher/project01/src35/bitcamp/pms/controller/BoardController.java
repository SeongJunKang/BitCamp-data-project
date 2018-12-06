package bitcamp.pms.controller;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@Controller
@RequestMapping("board/") 
public class BoardController {
  @Autowired
  private BoardDao boardDao;

  @RequestMapping("add.do")
  public void add(Map<String,String> paramMap, PrintStream out) {
    Board board = new Board();
    board.setTitle(paramMap.get("title"));
    board.setContent(paramMap.get("content"));
    board.setPassword(paramMap.get("password"));
    
    try {
      boardDao.insert(board);
      out.println("저장하였습니다.");
      
    } catch (Exception e) {
      out.println("데이터를 저장할 수 없습니다.");
    }
  }
  
  @RequestMapping("view.do")
  public void view(Map<String,String> paramMap, PrintStream out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
  
      Board board = boardDao.selectOne(no);
      if (board == null) {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
        return;
      }
      
      out.printf("번호: %d\n", board.getNo());
      out.printf("제목: %s\n", board.getTitle());
      out.println("내용:");
      out.println(board.getContent());
      out.printf("조회수: %d\n", board.getViews());
      out.printf("등록일: %s\n", board.getCreatedDate());
      
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    } 
  }
  
  @RequestMapping("delete.do")
  public void delete(Map<String,String> paramMap, PrintStream out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
  
      int count = boardDao.delete(no);
      if (count > 0) {
        out.println("삭제하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
      
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    } 
  }
  
  @RequestMapping("list.do")
  public void list(PrintStream out) {
    try {
      List<Board> boards = boardDao.selectList();
      
      for (Board board : boards) {
        out.printf("%d, %s, %d, %s\n", 
          board.getNo(), board.getTitle(), board.getViews(), board.getCreatedDate());
      }
    } catch (Exception e) {
      throw new RuntimeException("게시물 데이터 로딩 실패!", e);
    }
  }
  
  @RequestMapping("update.do")
  public void update(Map<String,String> paramMap, PrintStream out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
      
      Board board = boardDao.selectOne(no);
      
      if (board == null) {
        out.println("유효하지 않은 번호입니다.");
        return;
      }
      
      board.setTitle(paramMap.get("title"));
      board.setContent(paramMap.get("content"));
  
      int count = boardDao.update(board);
      
      if (count > 0) {
        out.println("변경하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    }
  }

}
