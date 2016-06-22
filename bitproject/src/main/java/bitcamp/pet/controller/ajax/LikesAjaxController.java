package bitcamp.pet.controller.ajax;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.pet.service.LikesService;
import bitcamp.pet.vo.Likes;

@Controller
@RequestMapping("/ajax/likes/")
public class LikesAjaxController {

  @Autowired
  LikesService likesService;

  @RequestMapping(produces="application/json;charset=UTF-8", value="add")
  @ResponseBody
  public String add(int mno, int pno) 
      throws ServletException, IOException {
    Likes likes = new Likes();
    likes.setMno(mno);
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
  public String delete(int mno) throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      likesService.delete(mno);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="bymno")
  @ResponseBody
  public String bymno(int mno)
      throws ServletException, IOException {
    
    return  new Gson().toJson(likesService.retrieveByMNO(mno));
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="count")
  @ResponseBody
  public String count(int pno)
      throws ServletException, IOException {
    return  new Gson().toJson(likesService.countAll(pno));
  }
}
