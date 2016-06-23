package bitcamp.pet.controller.ajax;

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

import bitcamp.pet.service.MemberService;
import bitcamp.pet.service.PetSitterService;
import bitcamp.pet.vo.Member;
import bitcamp.pet.vo.PetSitter;

@Controller
@RequestMapping("/ajax/petsitter/")
public class PetSitterAjaxController {

  @Autowired
  PetSitterService petsitterService;
  @Autowired
  MemberService memberService;

  @RequestMapping(produces="application/json;charset=UTF-8", value="add")
  @ResponseBody
  public String add(int pno, String nick, int amt, String ktalk, String bank, String bknm,
      String acc, String ser, String inqur, String pet, String addr_1, String addr_2,
      int rad, String lat, String lnt, String intro) 
      throws ServletException, IOException {
    PetSitter petsitter = new PetSitter();
    petsitter.setPno(pno);
    petsitter.setNick(nick);
    petsitter.setAmt(amt);
    petsitter.setKtalk(ktalk);
    petsitter.setBank(bank);
    petsitter.setBknm(bknm);
    petsitter.setBank(bank);
    petsitter.setAcc(acc);
    petsitter.setSer(ser);
    petsitter.setInqur(inqur);
    petsitter.setPet(pet);
    petsitter.setAddr_1(addr_1);
    petsitter.setAddr_2(addr_2);
    petsitter.setRad(rad);
    petsitter.setLat(lat);
    petsitter.setLnt(lnt);
    petsitter.setIntro(intro);
    HashMap<String,Object> result = new HashMap<>();
    try {
      result.put("status", "success");
      petsitterService.add(petsitter);
      Member member = memberService.retrieveByNo(pno);
      member.setGra(2);
      memberService.change(member);
    } catch(Exception e) {
      result.put("status", "failure"); 
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="delete")
  @ResponseBody
  public String delete(int no) throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      petsitterService.delete(no);
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
      result.put("lat",petsitter.getLat());
      result.put("lnt",petsitter.getLnt());
      result.put("rad",petsitter.getRad());
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return  new Gson().toJson(result);
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
    int totalPage = petsitterService.countPage(pageSize);
    if (pageNo > totalPage ) {
      pageNo = totalPage;
    }
    
    List<PetSitter> list = petsitterService.list(pageNo,pageSize);
    HashMap<String,Object> result = new HashMap<>();
    result.put("pageNo", pageNo);
    result.put("pageSize", pageSize);
    result.put("totalPage", totalPage);
    result.put("list", list);
    return new Gson().toJson(result);
  }

  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="update")
  @ResponseBody
  public String update(int no, String name, String password, String tel)
      throws ServletException, IOException {

    PetSitter petsitter = petsitterService.retrieveByNo(no);
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

}
