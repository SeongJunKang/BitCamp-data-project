package bitcamp.pms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@Component("/member/update")
public class MemberUpdateController {
  @Autowired
  MemberDao memberDao;
  
  public String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setTel(request.getParameter("tel"));
    
    memberDao.update(member);
    
    return "redirect:list.do";
  }
}










