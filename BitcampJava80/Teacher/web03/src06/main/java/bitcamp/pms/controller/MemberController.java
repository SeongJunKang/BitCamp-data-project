package bitcamp.pms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@Component
@RequestMapping("/member/")
public class MemberController {
  @Autowired
  MemberDao memberDao;
  
  @RequestMapping("add")
  public String add(
      @RequestParam("name") String name,
      @RequestParam("email") String email,
      @RequestParam("password") String password,
      @RequestParam("tel") String tel) throws ServletException, IOException {

    Member member = new Member();
    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setTel(tel);
    
    memberDao.insert(member);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(@RequestParam("no") int no) 
      throws ServletException, IOException {
    
    memberDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(
      HttpServletRequest request, 
      @RequestParam("no") int no) throws ServletException, IOException {
    
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", no);
    
    Member member = memberDao.selectOne(paramMap);
    
    request.setAttribute("member", member);
    return "/member/MemberDetail.jsp";
  }
  
  @RequestMapping("list")
  public String list(
      HttpServletRequest request) throws ServletException, IOException {
    
    List<Member> list = memberDao.selectList();
    
    request.setAttribute("list", list);
    return "/member/MemberList.jsp";
  }
  
  @RequestMapping("new")
  public String form() throws ServletException, IOException {
    return "/member/MemberForm.jsp";
  }
  
  @RequestMapping("update")
  public String update(
      @RequestParam("no") int no,
      @RequestParam("name") String name,
      @RequestParam("email") String email,
      @RequestParam("password") String password,
      @RequestParam("tel") String tel) throws ServletException, IOException {
    
    Member member = new Member();
    member.setNo(no);
    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setTel(tel);
    
    memberDao.update(member);
    
    return "redirect:list.do";
  }
}
