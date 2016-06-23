package bitcamp.pet.controller.ajax;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;

import bitcamp.pet.service.MemberService;
import bitcamp.pet.vo.Member;

@Controller
@RequestMapping("/ajax/member/")
public class MemberAjaxController {

  @Autowired
  MemberService memberService;

  @RequestMapping(produces="application/json;charset=UTF-8", value="add")
  @ResponseBody
  public String add(String name, String email, String password, String tel,String gen, String bth,String agc) 
      throws ServletException, IOException {
    Member member = new Member();
    member.setName(name);
    member.setEmail(email);
    member.setPwd(password);
    member.setTel(tel);
    member.setGen(gen);
    member.setAgency(agc);
    member.setBth(Date.valueOf(bth));
    member.setGra(1);
    HashMap<String,Object> result = new HashMap<>();
    try {
      result.put("status", "success");
      memberService.add(member);
    } catch(Exception e) {
      result.put("status", "failure"); 
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="checkemail")
  @ResponseBody
  public String checkemail(String email) 
      throws ServletException, IOException {
    Member member = memberService.retrieveByEmail(email);
    HashMap<String,Object> result = new HashMap<>();
    if ( member == null) {
      result.put("status", "success");
    } else {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
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
    Member member = (Member)memberService.retrieveByNo(no);
    HashMap<String,Object> result = new HashMap<>();
    result.put("name",member.getName());
    result.put("email",member.getEmail());
    result.put("tel",member.getTel());
    result.put("gra",member.getGra());
    result.put("pwd",member.getPwd());
    try {
      result.put("prof",member.getProf());
    } catch (Exception e) {
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

  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="update")
  @ResponseBody
  public String update(/*MultipartHttpServletRequest request,*/ int no, String name, String password, String tel, int gra)
      throws ServletException, IOException {
    Member member = memberService.retrieveByNo(no);
    /*
    Map<String, MultipartFile> files = request.getFileMap();
    CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("uploadFile");
    int extPoint = cmf.getOriginalFilename().lastIndexOf(".");
    String fileName = System.currentTimeMillis()+count()
                        + cmf.getOriginalFilename().substring(extPoint);
    // 경로
    String path ="bitproject/img/profiles/"+fileName;

    // 파일 업로드 처리 완료.
    try {
      cmf.transferTo(new File(path));
      System.out.println("새 파일명 : " + fileName);
      System.out.printf("새 파일을 저장할 실제 경로 = %s\n", path);
      member.setProf(path);
    } catch (Exception e) {
    }*/
    
    
    if (!password.equals("")){
      member.setPwd(password);
    }
    if (!name.equals("")) {
      member.setName(name);
    }
    if (!tel.equals("")) {
      member.setTel(tel);
    }
    HashMap<String, Object> result = new HashMap<>();
    try {
      memberService.change(member);
      result.put("status", "success");
    } catch(Exception e) {
      result.put("status", "failure");
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }
  
  int countno = 0;

  synchronized private int count() {
    int i = ++countno;
    if (i == 1000)
      i = 1;
    return i;
  }
}
