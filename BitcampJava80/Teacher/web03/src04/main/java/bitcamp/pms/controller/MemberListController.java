package bitcamp.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@Component("/member/list")
public class MemberListController {
  @Autowired
  MemberDao memberDao;
  
  public String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    List<Member> list = memberDao.selectList();
    
    response.setContentType("text/html;charset=UTF-8");

    request.setAttribute("list", list);
    return "/member/MemberList.jsp";
  }
}










