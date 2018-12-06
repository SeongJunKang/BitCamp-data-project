package bitcamp.pms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@Controller
@RequestMapping("/member/")
public class MemberController {
  @Autowired
  MemberDao memberDao;
  
  @RequestMapping("add")
  public String add(String name, String email, String password, String tel) throws ServletException, IOException {

    Member member = new Member();
    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setTel(tel);
    
    memberDao.insert(member);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no) 
      throws ServletException, IOException {
    
    memberDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws ServletException, IOException {
    
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", no);
    
    Member member = memberDao.selectOne(paramMap);
    
    model.addAttribute("member", member);
    return "member/MemberDetail";
  }
  
  @RequestMapping("list")
  public String list(Model model) throws ServletException, IOException {
    
    List<Member> list = memberDao.selectList();
    
    model.addAttribute("list", list);
    return "member/MemberList";
  }
  
  @RequestMapping("new")
  public String form() throws ServletException, IOException {
    return "member/MemberForm";
  }
  
  @RequestMapping("update")
  public String update(int no, String name, String email, String password, String tel) throws ServletException, IOException {
    
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
