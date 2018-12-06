package bitcamp.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.vo.Board;

@Controller
@RequestMapping("/board/")
public class BoardController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("add")
  public String add(String title, String content) throws ServletException, IOException {

    Board board = new Board();
    board.setTitle(title);
    board.setContent(content);
    
    boardDao.insert(board);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no) 
      throws ServletException, IOException {
    
    boardDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws ServletException, IOException {
    
    Board board = boardDao.selectOne(no);
    
    model.addAttribute("board", board);
    return "board/BoardDetail";
  }
  
  @RequestMapping("list")
  public String list(Model model) 
      throws ServletException, IOException {
    
    List<Board> list = boardDao.selectList();
    
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
    
    boardDao.update(board);
    
    return "redirect:list.do";
  }
}
