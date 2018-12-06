package bitcamp.pms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@Component
@RequestMapping("/member/")
public class MemberController {
  @Autowired
  MemberDao memberDao;
  
  @RequestMapping("add")
  public String add(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {

    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setTel(request.getParameter("tel"));
    
    memberDao.insert(member);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    int no = Integer.parseInt(request.getParameter("no"));
    memberDao.delete(no);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", Integer.parseInt(request.getParameter("no")));
    
    Member member = memberDao.selectOne(paramMap);
    
    response.setContentType("text/html;charset=UTF-8");
    
    request.setAttribute("member", member);
    return "/member/MemberDetail.jsp";
  }
  
  @RequestMapping("list")
  public String list(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    List<Member> list = memberDao.selectList();
    
    response.setContentType("text/html;charset=UTF-8");

    request.setAttribute("list", list);
    return "/member/MemberList.jsp";
  }
  
  @RequestMapping("new")
  public String form(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    return "/member/MemberForm.jsp";
  }
  
  @RequestMapping("update")
  public String update(
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
