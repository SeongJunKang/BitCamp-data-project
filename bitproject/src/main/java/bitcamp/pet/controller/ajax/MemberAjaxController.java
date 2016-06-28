package bitcamp.pet.controller.ajax;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;

import bitcamp.pet.service.MemberService;
import bitcamp.pet.service.PetSitterService;
import bitcamp.pet.vo.Member;
import bitcamp.pet.vo.PetSitter;

@Controller
@RequestMapping("/ajax/member/")
public class MemberAjaxController {
  final static String passwordFormat = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{4,10}$";
  
  @Autowired
  MemberService memberService;
  
  @Autowired
  PetSitterService petsitterService;
  
  @Autowired
  ServletContext servletContext;

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
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="getbirth")
  @ResponseBody
  public String birth(int mno) 
      throws ServletException, IOException {
    Member member = memberService.retrieveByNo(mno);
    HashMap<String,Object> result = new HashMap<>();
    result.put("bth",member.getBth());
    result.put("status", "success");
    if(result.get("bth") ==null) {
      result.put("status", "failure");
    }
    return  new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="detail")
  @ResponseBody
  public String detail(HttpSession session) 
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    HashMap<String,Object> result = new HashMap<>();
    result.put("name",member.getName());
    result.put("email",member.getEmail());
    result.put("tel",member.getTel());
    result.put("gra",member.getGra());
    result.put("agc",member.getAgency());
    try {
      result.put("prof",member.getProf());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return  new Gson().toJson(result);
  }

  @RequestMapping(produces="application/json;charset=UTF-8", value="list")
  @ResponseBody
  public String list() throws ServletException, IOException {
    List<Member> list = memberService.list();
    HashMap<String,Object> result = new HashMap<>();
    result.put("list", list);
    return new Gson().toJson(result);
  }

  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="update")
  @ResponseBody
  public String update(HttpSession session,String agc, String name,String nowpassword, String passwordchk,
      String phone1,String phone2,String phone3, String password)
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    
    if ((nowpassword.equals("") && passwordchk.equals("") && password.equals("")) // 패스워드 3개가 빈칸이거나
        ||(member.getPwd() == nowpassword)) {                                     // 현재 비밀번호와 체크비밀번호가 같다면,
      if ((!password.equals("")) && (password.equals(passwordchk))){
        member.setPwd(password);
      }
    }
    member.setAgency(agc);              //통신사 변경
    member.setName(name);               //이름변경
    member.setTel(phone1+"-"+phone2+"-"+phone3);//전화번호변경
    
    HashMap<String, Object> result = new HashMap<>();
    try {
      memberService.change(member);     // 회원정보 변경 신청
      result.put("status", "success");
    } catch(Exception e) {
      result.put("status", "failure");
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }
 
  @RequestMapping(method=RequestMethod.POST,
      produces="application/json;charset=UTF-8", value="upgrade")
  @ResponseBody
  public String update(HttpSession session,int gra)
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    member.setGra(gra);
    HashMap<String, Object> result = new HashMap<>();
    try {
      memberService.change(member);     // 회원정보 변경 신청
      result.put("status", "success");
    } catch(Exception e) {
      result.put("status", "failure");
      e.printStackTrace();
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(method=RequestMethod.POST,produces="application/json;charset=UTF-8", value="upload")
  @ResponseBody
  public String upload(MultipartHttpServletRequest request,
      HttpSession session,String agc, String name,String nowpassword, String passwordchk,
      String phone1,String phone2,String phone3, String password)
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    HashMap<String, Object> result = new HashMap<>();

    if (nowpassword.equals("") ||(member.getPwd().equals(nowpassword))) { // 패스워드가 빈칸이거나 현재 비밀번호와 체크비밀번호가 같다면,
      if (!password.equals(passwordchk)) {
        result.put("status", "failure");
        return new Gson().toJson(result);
      } else {
        if(((!password.equals("")) && (password.matches(passwordFormat)))) {
          member.setPwd(password);
        }
        member.setAgency(agc);
        member.setName(name);
        member.setTel(phone1+"-"+phone2+"-"+phone3);//전화번호변경
      }
    } else {
      result.put("status", "failure");
    }
    Map<String, MultipartFile> files = request.getFileMap();
    CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("uploadFile");
    int extPoint = cmf.getOriginalFilename().lastIndexOf(".");
    String fileName = "";
    if (extPoint > 0){
      fileName = System.currentTimeMillis() + count() + cmf.getOriginalFilename().substring(extPoint);      
      
//      String realPath = servletContext.getRealPath("img/profiles/" + fileName);
      String realPath = servletContext.getRealPath("img/profiles/");
      try {
//        cmf.transferTo(new File(realPath));
        cmf.transferTo(new File(realPath+fileName));
        /*member.setProf("img/profiles/"+fileName);*/
        System.out.printf("새 파일을 저장할 실제 경로=%s\n", realPath);
        System.out.println("새 파일명 : " + fileName);
        //썸네일 가로사이즈
        int thumbnail_width = 400;
        //썸네일 세로사이즈
        int thumbnail_height = 285;
        //원본이미지파일의 경로+파일명
        File origin_file_name = new File(realPath + fileName);
        //생성할 썸네일파일의 경로+썸네일파일명
        File thumb_file_name = new File(realPath+"/thumb/"+fileName);
        BufferedImage buffer_original_image = ImageIO.read(origin_file_name);
        BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphic = buffer_thumbnail_image.createGraphics();
        graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
        ImageIO.write(buffer_thumbnail_image, "jpg", thumb_file_name);
        
        member.setProf("img/profiles/thumb/"+fileName);
        System.out.println("썸네일 생성완료");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    PetSitter petsitter = null;
    if (petsitterService.exist(member.getMno())) {
      try {
        petsitter =(PetSitter)petsitterService.retrieveByNo(member.getMno());
        petsitter.setImg("../"+member.getProf());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    try{
      petsitterService.change(petsitter);
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
