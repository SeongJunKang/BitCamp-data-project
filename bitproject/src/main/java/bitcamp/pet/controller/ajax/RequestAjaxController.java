package bitcamp.pet.controller.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.pet.service.RequestService;
import bitcamp.pet.vo.Member;
import bitcamp.pet.vo.Request;

@Controller
@RequestMapping("/ajax/request/")
public class RequestAjaxController {

  @Autowired
  RequestService requestService;
//  @Autowired
//  PetSitterService petsitterService;
//  @Autowired
//  MemberService memberService;

  @RequestMapping(produces="application/json;charset=UTF-8", value="add")
  @ResponseBody
  public String add(HttpSession session, int pno, String date,
      String conts, String res, String neut, String anifd,
      String manfd, String bark, String diz, String meal, String train) 
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    System.out.println(member.getName());
    Request request = new Request();
    request.setMno(member.getMno());
    request.setPno(pno);
    request.setDate(date);
    request.setConts(conts);
    request.setRes(res);
    request.setNeut(neut);
    request.setAnifd(anifd);
    request.setManfd(manfd);
    request.setBark(bark);
    request.setDiz(diz);
    request.setMeal(meal);
    request.setTrain(train);
    
    HashMap<String,Object> result = new HashMap<>();
    try {
      result.put("status", "success");
      requestService.add(request);
    } catch(Exception e) {
      result.put("status", "failure"); 
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="delete")
  @ResponseBody
  public String delete(HttpSession session) throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      requestService.delete(((Member)session.getAttribute("loginUser")).getMno());
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
    Request request= (Request)requestService.retrieveByNo(no);
    HashMap<String,Object> result = new HashMap<>();
    try {
      //select BANK,BKNM,ACC,SER,INQUR,PET,ADDR_1,ADDR_2,INTRO,RAD,LAT,LNT,REG from PETSITTER
      result.put("name",request.getMno());   
      result.put("nick",request.getPno());     
      result.put("conts",request.getConts());   
      result.put("res",request.getRes());     
      result.put("neut",request.getNeut()); // 요구사항
      result.put("anifd",request.getAnifd());     // 펫시터 펫마리수
      result.put("manfd",request.getManfd()); // 우편주소1
      result.put("bark",request.getBark()); // 상세주소1
      result.put("diz",request.getDiz()); // 상세주소2
      result.put("meal",request.getMeal());   // 자기소개
      result.put("train",request.getTrain());    // 활동지역
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return  new Gson().toJson(result);
  }

  
  @RequestMapping(produces="application/json;charset=UTF-8", value="list")
  @ResponseBody
  public String list(String order) throws ServletException, IOException {
    List<Request> list = requestService.list(order);
    HashMap<String,Object> result = new HashMap<>();
    result.put("list", list);
    return new Gson().toJson(result);
  }
}
