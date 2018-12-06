package bitcamp.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.vo.Board;

@Component("/board/list")
public class BoardListController {
  @Autowired
  BoardDao boardDao;
  
  public String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    List<Board> list = boardDao.selectList();
    
    request.setAttribute("list", list);
    return "/board/BoardList.jsp";
  }
}










