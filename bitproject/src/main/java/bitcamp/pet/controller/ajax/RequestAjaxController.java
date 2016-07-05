package bitcamp.pet.controller.ajax;

import java.io.IOException;
import java.sql.Date;
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

import bitcamp.pet.service.MemberService;
import bitcamp.pet.service.PetSitterService;
import bitcamp.pet.service.RequestService;
import bitcamp.pet.vo.Member;
import bitcamp.pet.vo.PetSitter;
import bitcamp.pet.vo.Request;

@Controller
@RequestMapping("/ajax/request/")
public class RequestAjaxController {

  @Autowired
  RequestService requestService;
  @Autowired
  PetSitterService petsitterService;
  @Autowired
  MemberService memberService;

  @RequestMapping(produces="application/json;charset=UTF-8", value="add")
  @ResponseBody
  public String add(HttpSession session, int req, int mno, int pno, Date cdt,
      String conts, String stat, String ans, String res, String neut, String anifd,
      String manfd, String bark, String diz, String meal, String train) 
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    PetSitter petsitter = new PetSitter();
    Request request = new Request();
    petsitter.setPno(member.getMno());
    request.setReq(req);
    request.setMno(mno);
    request.setPno(pno);
    request.setCdt(cdt);
    request.setConts(conts);
    request.setStat(stat);
    request.setAns(ans);
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
      petsitterService.delete(((Member)session.getAttribute("loginUser")).getMno());
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
    PetSitter petsitter = (PetSitter)petsitterService.retrieveByNo(no);
    HashMap<String,Object> result = new HashMap<>();
    try {
      //select BANK,BKNM,ACC,SER,INQUR,PET,ADDR_1,ADDR_2,INTRO,RAD,LAT,LNT,REG from PETSITTER
      result.put("nick",petsitter.getNick());   // 닉네임
      result.put("amt",petsitter.getAmt());     // 가격
      result.put("ktalk",petsitter.getKtalk()); // 카톡
      result.put("bank",petsitter.getBank());   // 은행
      result.put("bknm",petsitter.getBknm());   // 예금명
      result.put("acc",petsitter.getAcc());     // 계좌
      result.put("ser",petsitter.getSer());     // 서비스
      result.put("inqur",petsitter.getInqur()); // 요구사항
      result.put("pet",petsitter.getPet());     // 펫시터 펫마리수
      result.put("addr_1",petsitter.getAddr_1()); // 우편주소1
      result.put("addr_2",petsitter.getAddr_2()); // 상세주소1
      result.put("addr_3",petsitter.getAddr_3()); // 상세주소2
      result.put("intro",petsitter.getIntro());   // 자기소개
      result.put("reg",petsitter.getRegion());    // 활동지역
      result.put("lat",petsitter.getLat());     //  좌표
      result.put("lnt",petsitter.getLnt());     // 좌표
      result.put("rad",petsitter.getRad());     // 반지름
      result.put("img",petsitter.getImg());     // 이미지
      result.put("likes",petsitter.getLikes());  // 좋아요수
      result.put("petg",petsitter.getPetg());    // 펫등급
      result.put("hospital",petsitter.getHospital());    // 펫등급
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return  new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="petmypage")
  @ResponseBody
  public String detail(HttpSession session) 
      throws ServletException, IOException {
    PetSitter petsitter = (PetSitter)petsitterService.retrieveByNo(
        ((Member)session.getAttribute("loginUser")).getMno());
    HashMap<String,Object> result = new HashMap<>();
    try {
      //select BANK,BKNM,ACC,SER,INQUR,PET,ADDR_1,ADDR_2,INTRO,RAD,LAT,LNT,REG from PETSITTER
      result.put("nick",petsitter.getNick());   // 닉네임
      result.put("amt",petsitter.getAmt());     // 가격
      result.put("ktalk",petsitter.getKtalk()); // 카톡
      result.put("bank",petsitter.getBank());   // 은행
      result.put("bknm",petsitter.getBknm());   // 예금명
      result.put("acc",petsitter.getAcc());     // 계좌
      result.put("ser",petsitter.getSer());     // 서비스
      result.put("inqur",petsitter.getInqur()); // 요구사항
      result.put("pet",petsitter.getPet());     // 펫시터 펫마리수
      result.put("addr_1",petsitter.getAddr_1()); // 우편주소1
      result.put("addr_2",petsitter.getAddr_2()); // 상세주소1
      result.put("addr_3",petsitter.getAddr_3()); // 상세주소2
      result.put("intro",petsitter.getIntro());   // 자기소개
      result.put("reg",petsitter.getRegion());    // 활동지역
      result.put("lat",petsitter.getLat());     //  좌표
      result.put("lnt",petsitter.getLnt());     // 좌표
      result.put("rad",petsitter.getRad());     // 반지름
      result.put("img",petsitter.getImg());     // 이미지
      result.put("likes",petsitter.getLikes());  // 좋아요수
      result.put("petg",petsitter.getPetg());    // 펫등급
      result.put("hospital",petsitter.getHospital());    // 펫등급
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return  new Gson().toJson(result);
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="list")
  @ResponseBody
  public String list(String order) throws ServletException, IOException {
    List<PetSitter> list = petsitterService.list(order);
    HashMap<String,Object> result = new HashMap<>();
    result.put("list", list);
    return new Gson().toJson(result);
  }


  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="update")
  @ResponseBody
  public String update(HttpSession session)
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    PetSitter petsitter = petsitterService.retrieveByNo(member.getMno());
    petsitter.setImg("../"+member.getProf());
    HashMap<String, Object> result = new HashMap<>();
    try {
      petsitterService.change(petsitter);
      result.put("status", "success");
    } catch(Exception e) {
      result.put("status", "failure");
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="like")
  @ResponseBody
  public String like(int pno, int likes)
      throws ServletException, IOException {
    
    PetSitter petsitter = petsitterService.retrieveByNo(pno);
    petsitter.setLikes(likes);
    HashMap<String, Object> result = new HashMap<>();
    try {
      petsitterService.change(petsitter);
      result.put("status", "success");
    } catch(Exception e) {
      result.put("status", "failure");
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="upload")
  @ResponseBody
  public String upload(HttpSession session, String nickname,int amt,
      String ktalk,String region, String bank, String bknm, String acc,
      String box, String inqur1,String inqur2, String pet, int hos, String addr1, 
      String addr2,String addr3, int rad, String intro,String lat, String lnt)
      throws ServletException, IOException {
    
    PetSitter petsitter = petsitterService.retrieveByNo(((Member)session.getAttribute("loginUser")).getMno());
    petsitter.setNick(nickname);
    petsitter.setAmt(amt);
    petsitter.setKtalk(ktalk);
    petsitter.setRegion(region);
    petsitter.setBank(bank);
    petsitter.setBknm(bknm);
    petsitter.setAcc(acc);
    petsitter.setSer(box);
    petsitter.setInqur(inqur1+"시 ~"+inqur2+"시");
    petsitter.setPet(pet);
    petsitter.setHospital(hos);
    petsitter.setAddr_1(addr1);
    petsitter.setAddr_2(addr2);
    petsitter.setAddr_3(addr3);
    petsitter.setRad(rad);
    petsitter.setLat(lat);
    petsitter.setLnt(lnt);
    petsitter.setIntro(intro);
    System.out.println(nickname);
    System.out.println(amt);
    System.out.println(ktalk);
    System.out.println(region);
    System.out.println(bank);
    System.out.println(bknm);
    System.out.println(acc);
    System.out.println(box);
    HashMap<String, Object> result = new HashMap<>();
    try {
      petsitterService.setInfo(petsitter);
      result.put("status", "success");
    } catch(Exception e) {
      result.put("status", "failure");
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="checknick")
  @ResponseBody
  public String checknick(String nick) 
      throws ServletException, IOException {
    PetSitter petsitter = petsitterService.retrieveByNick(nick);
    HashMap<String,Object> result = new HashMap<>();
    if ( petsitter == null) {
      result.put("status", "success");
    } else {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
}