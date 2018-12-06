package bitcamp.pms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.pms.dao.BoardDao;

@Component("/board/delete")
public class BoardDeleteController {
  @Autowired
  BoardDao boardDao;
  
  public String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {

    int no = Integer.parseInt(request.getParameter("no"));
    boardDao.delete(no);
    
    return "redirect:list.do";
  }
}










