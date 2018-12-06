package bitcamp.pms.controller;

import java.io.IOException;
import java.util.HashMap;
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

  @Autowired
  MemberService memberService;

  @RequestMapping("add")
  public String add(String name, String email, String password, String tel) 
      throws ServletException, IOException {
    Member member = new Member();
    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setTel(tel);
    memberService.add(member);
    return "redirect:list.do";
  }

  @RequestMapping("delete")
  public String delete(int no) throws ServletException, IOException {
    memberService.delete(no);
    return "redirect:list.do";
  }

  @RequestMapping("detail")
  public String detail(int no, Model model) 
      throws ServletException, IOException {
    Member member = memberService.retrieveByNo(no);
    model.addAttribute("member", member);
    return "/member/MemberDetail";
  }

  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1")int pageNo,
      @RequestParam(defaultValue="3")int pageSize,
      Model model) throws ServletException, IOException {
    if (pageNo < 0) {
      pageNo = 1;
    }
    int totalPage = memberService.countPage(pageSize);
    if (pageNo > totalPage ) {
      pageNo = totalPage;
    }
    
    if (pageSize < 3) {
      pageSize = 3;
    } else if (pageSize > 50) {
      pageSize = 50;
    }
    
    List<Member> list = memberService.list(pageNo,pageSize);
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPage", totalPage);
    model.addAttribute("memberlist", list);
    return "/member/MemberList";
  }

  @RequestMapping("new")
  public String newMember() throws ServletException, IOException {
    return "/member/MemberNewMember";
  }

  @RequestMapping("update")
  public String update(int no, String name, String email, String password, String tel)
      throws ServletException, IOException {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("no", no);

    Member member = memberService.retrieveByNo(no);
    member.setName(name);
    member.setEmail(email);
    member.setTel(tel);
    memberService.change(member);
    return "redirect:list.do";
  }

}
