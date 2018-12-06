package bitcamp.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.service.BoardService;
import bitcamp.pms.vo.Board;

@Controller
@RequestMapping("/board/")
public class BoardController {
  @Autowired BoardService boardService;
  
  @RequestMapping("add")
  public String add(String title, String content) throws ServletException, IOException {

    Board board = new Board();
    board.setTitle(title);
    board.setContent(content);
    
    boardService.add(board);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no) 
      throws ServletException, IOException {
    
    boardService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws ServletException, IOException {
    
    Board board = boardService.retrieve(no);
    
    model.addAttribute("board", board);
    return "board/BoardDetail";
  }
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="3") int pageSize, Model model) 
      throws ServletException, IOException {
    
    // 페이지 번호와 페이지 당 출력 개수의 유효성 검사
    if (pageNo < 0) { // 1페이지 부터 시작
      pageNo = 1;
    }
    
    int totalPage = boardService.countPage(pageSize);
    if (pageNo > totalPage) { // 가장 큰 페이지 번호를 넘지 않게 한다.
      pageNo = totalPage;
    }
    
    if (pageSize < 3) { // 최소 3개
      pageSize = 3; 
    } else if (pageSize > 50) { // 최대 50개 
      pageSize = 50;
    }
    
    List<Board> list = boardService.list(pageNo, pageSize);
    
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPage", totalPage);
    model.addAttribute("list", list);
    
    return "board/BoardList";
  }
  
  @RequestMapping("new")
  public String form() throws ServletException, IOException {
    return "board/BoardForm";
  }
  
  @RequestMapping("update")
  public String update(int no, String title, String content) throws ServletException, IOException {
    
    Board board = new Board();
    board.setNo(no);
    board.setTitle(title);
    board.setContent(content);
    
    boardService.change(board);
    
    return "redirect:list.do";
  }
}
