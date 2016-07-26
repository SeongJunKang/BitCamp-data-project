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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.pet.service.MemberService;
import bitcamp.pet.service.PetSitterService;
import bitcamp.pet.service.RequestService;
import bitcamp.pet.vo.Member;
import bitcamp.pet.vo.Petrequest;
import bitcamp.pet.vo.Request;

@Controller
@RequestMapping("/ajax/request/")
public class RequestAjaxController {

  @Autowired
  RequestService requestService;
  @Autowired
  MemberService memberService;
  @Autowired
  PetSitterService petsitterService;
//  @Autowired
//  MemberService memberService;

  @RequestMapping(produces="application/json;charset=UTF-8", value="add")
  @ResponseBody
  public String add(HttpSession session, int pno, String date,
      String conts, String res, String neut, String anifd,
      String manfd, String bark, String diz, String meal, String train) 
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    HashMap<String,Object> result = new HashMap<>();
    if (member.getMno() == pno) {
      result.put("status", "same");
      return new Gson().toJson(result);
    }
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
    
    try {
      result.put("status", "success");
      requestService.add(request);
    } catch(Exception e) {
      e.printStackTrace();
      result.put("status", "failure"); 
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(value="delete", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String delete(int req) 
      throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      requestService.delete(req);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="detail")
  @ResponseBody
  public String detail(int req) 
      throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    Petrequest request= requestService.retrieve(req);
    result.put("mname",memberService.retrieveByNo(request.getMno()).getName());
    result.put("pname",petsitterService.retrieveByNo(request.getPno()).getNick());
    result.put("request", request);
/*    HashMap<String,Object> result = new HashMap<>();
    try {
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }*/
    return  new Gson().toJson(result);
  }

  @RequestMapping(value="list", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String list(
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="3") int pageSize) 
      throws ServletException, IOException {
    // 페이지 번호와 페이지 당 출력 개수의 유효성 검사
    if (pageNo < 0) { // 1페이지 부터 시작
      pageNo = 1;
    }
    
    int totalPage = requestService.countPage(pageSize);
    if (pageNo > totalPage) { // 가장 큰 페이지 번호를 넘지 않게 한다.
      pageNo = totalPage;
    }
    
    if (pageSize < 3) { // 최소 3개
      pageSize = 3; 
    } else if (pageSize > 50) { // 최대 50개 
      pageSize = 50;
    }
    
    List<Request> list = requestService.list(pageNo, pageSize);
    
    HashMap<String,Object> result = new HashMap<>();
    result.put("pageNo", pageNo);
    result.put("pageSize", pageSize);
    result.put("totalPage", totalPage);
    result.put("list", list);
    
    return new Gson().toJson(result);
  }
  @RequestMapping(value="petrequestlist", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String petrequestlist(HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="20") int pageSize) 
      throws ServletException, IOException {
    
    // 페이지 번호와 페이지 당 출력 개수의 유효성 검사
    if (pageNo < 0) { // 1페이지 부터 시작
      pageNo = 1;
    }
    
    int totalPage = requestService.countPage(pageSize);
    if (pageNo > totalPage) { // 가장 큰 페이지 번호를 넘지 않게 한다.
      pageNo = totalPage;
    }
    
    if (pageSize < 3) { // 최소 3개
      pageSize = 3; 
    } else if (pageSize > 50) { // 최대 50개 
      pageSize = 50;
    }
    HashMap<String,Object> result = new HashMap<>();
    if ((Member)session.getAttribute("loginUser") != null) {
      List<Petrequest> list = requestService.petrequestlist(pageNo, pageSize, ((Member)session.getAttribute("loginUser")).getMno());
    
      result.put("pageNo", pageNo);
      result.put("pageSize", pageSize);
      result.put("totalPage", totalPage);
      result.put("list", list);
      result.put("status", "success");
    } else {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="myrequestlist", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String myrequestlist(HttpSession session,
      @RequestParam(defaultValue="1") int pageNo, 
      @RequestParam(defaultValue="20") int pageSize) 
      throws ServletException, IOException {
    
    // 페이지 번호와 페이지 당 출력 개수의 유효성 검사
    if (pageNo < 0) { // 1페이지 부터 시작
      pageNo = 1;
    }
    
    int totalPage = requestService.countPage(pageSize);
    if (pageNo > totalPage) { // 가장 큰 페이지 번호를 넘지 않게 한다.
      pageNo = totalPage;
    }
    
    if (pageSize < 3) { // 최소 3개
      pageSize = 3; 
    } else if (pageSize > 50) { // 최대 50개 
      pageSize = 50;
    }
    HashMap<String,Object> result = new HashMap<>();
    if ((Member)session.getAttribute("loginUser") != null) {
      List<Petrequest> list = requestService.myrequestlist(pageNo, pageSize, ((Member)session.getAttribute("loginUser")).getMno());
    
      result.put("pageNo", pageNo);
      result.put("pageSize", pageSize);
      result.put("totalPage", totalPage);
      result.put("list", list);
      result.put("status", "success");
    } else {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="update",
      method=RequestMethod.POST,
      produces="application/json;charset=UTF-8")
  @ResponseBody
  public String update(int req, String stat) throws ServletException, IOException {
    
    Request request= new Request();
    request.setReq(req);
    request.setStat(stat);
    
    HashMap<String,Object> result = new HashMap<>();
    try {
      requestService.change(request);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="accrue",
      method=RequestMethod.POST,
      produces="application/json;charset=UTF-8")
  @ResponseBody
  public String accrue(int pno) throws ServletException, IOException {
    
    HashMap<String,Object> result = new HashMap<>();
    try {
      result.put("accrue", requestService.getAccrue(pno));
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  
}
