package bitcamp.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.vo.Board;

@Component
@RequestMapping("/board/")
public class BoardController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("add")
  public String add(
      @RequestParam("title") String title, 
      @RequestParam("content") String content) throws ServletException, IOException {

    Board board = new Board();
    board.setTitle(title);
    board.setContent(content);
    
    boardDao.insert(board);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(@RequestParam("no") int no) 
      throws ServletException, IOException {
    
    boardDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(
      HttpServletRequest request, 
      @RequestParam("no") int no) throws ServletException, IOException {
    
    Board board = boardDao.selectOne(no);
    
    request.setAttribute("board", board);
    return "/board/BoardDetail.jsp";
  }
  
  @RequestMapping("list")
  public String list(HttpServletRequest request) 
      throws ServletException, IOException {
    
    List<Board> list = boardDao.selectList();
    
    request.setAttribute("list", list);
    return "/board/BoardList.jsp";
  }
  
  @RequestMapping("new")
  public String form() throws ServletException, IOException {
    return "/board/BoardForm.jsp";
  }
  
  @RequestMapping("update")
  public String update(
      @RequestParam("no") int no,
      @RequestParam("title") String title,
      @RequestParam("content") String content) 
      throws ServletException, IOException {
    
    Board board = new Board();
    board.setNo(no);
    board.setTitle(title);
    board.setContent(content);
    
    boardDao.update(board);
    
    return "redirect:list.do";
  }
}
