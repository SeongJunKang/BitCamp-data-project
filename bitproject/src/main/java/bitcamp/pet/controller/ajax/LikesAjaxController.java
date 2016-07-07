package bitcamp.pet.controller.ajax;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.pet.service.LikesService;
import bitcamp.pet.vo.Likes;
import bitcamp.pet.vo.Member;

@Controller
@RequestMapping("/ajax/likes/")
public class LikesAjaxController {

  @Autowired
  LikesService likesService;

  @RequestMapping(produces="application/json;charset=UTF-8", value="add")
  @ResponseBody
  public String add(HttpSession session, int pno) 
      throws ServletException, IOException {
    Likes likes = new Likes();
    likes.setMno(((Member)session.getAttribute("loginUser")).getMno());
    likes.setPno(pno);
    HashMap<String,Object> result = new HashMap<>();
    try {
      result.put("status", "success");
      likesService.add(likes);
    } catch(Exception e) {
      result.put("status", "failure"); 
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="delete")
  @ResponseBody
  public String delete(HttpSession session,int pno) throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      likesService.delete(((Member)session.getAttribute("loginUser")).getMno(),pno);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="byno")
  @ResponseBody
  public String bymno(HttpSession session,int pno)
      throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      Likes likes = (Likes)likesService.retrieveByNO(((Member)session.getAttribute("loginUser")).getMno(),pno);
      result.put("mno", likes.getMno());
      result.put("pno", likes.getPno());
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="count")
  @ResponseBody
  public String count(int pno)
      throws ServletException, IOException {
    return  new Gson().toJson(likesService.countAll(pno));
  }
}
