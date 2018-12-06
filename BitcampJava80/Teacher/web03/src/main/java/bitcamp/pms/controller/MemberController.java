package bitcamp.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.service.MemberService;
import bitcamp.pms.vo.Member;

@Controller
@RequestMapping("/member/")
public class MemberController {
  @Autowired MemberService memberService;
  
  @RequestMapping("add")
  public String add(String name, String email, String password, String tel) throws ServletException, IOException {

    Member member = new Member();
    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setTel(tel);
    
    memberService.add(member);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no) 
      throws ServletException, IOException {
    
    memberService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws ServletException, IOException {
    Member member = memberService.retrieveByNo(no);
    model.addAttribute("member", member);
    return "member/MemberDetail";
  }
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="3") int pageSize, Model model) 
      throws ServletException, IOException {
    
    // 페이지 번호와 페이지 당 출력 개수의 유효성 검사
    if (pageNo < 0) { // 1페이지 부터 시작
      pageNo = 1;
    }
    
    int totalPage = memberService.countPage(pageSize);
    if (pageNo > totalPage) { // 가장 큰 페이지 번호를 넘지 않게 한다.
      pageNo = totalPage;
    }
    
    if (pageSize < 3) { // 최소 3개
      pageSize = 3; 
    } else if (pageSize > 50) { // 최대 50개 
      pageSize = 50;
    }
    
    List<Member> list = memberService.list(pageNo, pageSize);
    
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPage", totalPage);
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
    
    memberService.change(member);
    
    return "redirect:list.do";
  }
}
