package bitcamp.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.vo.Board;

@Component
@RequestMapping("/board/")
public class BoardController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("add")
  public String add(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {

    Board board = new Board();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    
    boardDao.insert(board);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {

    int no = Integer.parseInt(request.getParameter("no"));
    boardDao.delete(no);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    int no = Integer.parseInt(request.getParameter("no"));
    Board board = boardDao.selectOne(no);
    
    request.setAttribute("board", board);
    return "/board/BoardDetail.jsp";
  }
  
  @RequestMapping("list")
  public String list(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    List<Board> list = boardDao.selectList();
    
    request.setAttribute("list", list);
    return "/board/BoardList.jsp";
  }
  
  @RequestMapping("new")
  public String form(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    return "/board/BoardForm.jsp";
  }
  
  @RequestMapping("update")
  public String update(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    
    boardDao.update(board);
    
    return "redirect:list.do";
  }
}
