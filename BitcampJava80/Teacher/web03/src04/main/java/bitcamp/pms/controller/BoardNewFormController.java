package bitcamp.pms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component("/board/new")
public class BoardNewFormController {
  public String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    return "/board/BoardForm.jsp";
  }
}










