package bitcamp.pms.controller.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.pms.service.MemberService;
import bitcamp.pms.vo.Member;

@Controller
@RequestMapping("/ajax/member/")
public class MemberAjaxController {

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

  @RequestMapping(produces="application/json;charset=UTF-8", value="delete")
  @ResponseBody
  public String delete(int no) throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      memberService.delete(no);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="detail")
  @ResponseBody
  public String detail(int no) 
      throws ServletException, IOException {
    
    return  new Gson().toJson(memberService.retrieveByNo(no));
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="list")
  @ResponseBody
  public String list(
      @RequestParam(defaultValue="1")int pageNo,
      @RequestParam(defaultValue="3")int pageSize)
          throws ServletException, IOException {
    if (pageNo < 1) {
      pageNo = 1;
    }
    if (pageSize < 3) {
      pageSize = 3;
    } else if (pageSize > 20) {
      pageSize = 20;
    }
    int totalPage = memberService.countPage(pageSize);
    if (pageNo > totalPage ) {
      pageNo = totalPage;
    }
    
    List<Member> list = memberService.list(pageNo,pageSize);
    for (Member m : list) {
      if (m.getTel() == null) {
        m.setTel("");
      }
    }
    HashMap<String,Object> result = new HashMap<>();
    result.put("pageNo", pageNo);
    result.put("pageSize", pageSize);
    result.put("totalPage", totalPage);
    result.put("list", list);
    return new Gson().toJson(result);
  }

  @RequestMapping("new")
  public String newMember() throws ServletException, IOException {
    return "/member/MemberNewMember";
  }

  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="update")
  @ResponseBody
  public String update(int no, String name, String email, String password, String tel)
      throws ServletException, IOException {

    Member member = memberService.retrieveByNo(no);
    member.setName(name);
    member.setEmail(email);
    member.setTel(tel);
    HashMap<String, Object> result = new HashMap<>();
    try {
      memberService.change(member);
      result.put("status", "success");
    } catch(Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }

}
