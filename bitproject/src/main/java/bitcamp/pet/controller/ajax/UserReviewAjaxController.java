package bitcamp.pet.controller.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.pet.service.UserReviewService;
import bitcamp.pet.vo.Member;
import bitcamp.pet.vo.UserReview;

@Controller
@RequestMapping("/ajax/userreview/")
public class UserReviewAjaxController {
  @Autowired
  UserReviewService userreviewService;

  @RequestMapping(produces="application/json;charset=UTF-8", value="add")
  @ResponseBody
  public String add(HttpSession session, int pno, String review) 
      throws ServletException, IOException {
    UserReview userreview = new UserReview();
    HashMap<String,Object> result = new HashMap<>();
    Member member = ((Member)session.getAttribute("loginUser"));
    if ( member == null ) {
      result.put("status", "failure"); 
      return new Gson().toJson(result);
    } else if ( userreviewService.retrieveByNo(
        ((Member)session.getAttribute("loginUser")).getMno(), pno) != null) {
      result.put("status", "onlyone"); 
      return new Gson().toJson(result);
    }
    userreview.setMno(member.getMno());
    userreview.setPno(pno);
    userreview.setContent(review);
    try {
      result.put("status", "success");
      userreviewService.add(userreview);
    } catch(Exception e) {
      result.put("status", "failure"); 
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="delete")
  @ResponseBody
  public String delete(HttpSession session,int pno) throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      userreviewService.delete(((Member)session.getAttribute("loginUser")).getMno(),pno);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="list")
  @ResponseBody
  public String list(HttpSession session,int pno) throws ServletException, IOException {
    
    List<UserReview> list = userreviewService.list(pno,1);
    HashMap<String,Object> result = new HashMap<>();
    try { 
      result.put("userNo", ((Member)session.getAttribute("loginUser")).getMno());
    } catch( Exception e ) {
      result.remove("userNo");
    }
    result.put("list", list);
    return new Gson().toJson(result);
  }

  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="update")
  @ResponseBody
  public String update(HttpSession session,int pno, String review)
      throws ServletException, IOException {
    UserReview userreview = userreviewService.retrieveByNo(
        ((Member)session.getAttribute("loginUser")).getMno(), pno);
    userreview.setContent(review);
    HashMap<String, Object> result = new HashMap<>();
    try {
      userreviewService.change(userreview);
      result.put("status", "success");
    } catch(Exception e) {
      result.put("status", "failure");
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }
}
