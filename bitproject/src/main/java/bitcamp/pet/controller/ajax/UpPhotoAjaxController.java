/*package bitcamp.pet.controller.ajax;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import bitcamp.pet.service.UpPhotoService;
import bitcamp.pet.vo.Likes;
import bitcamp.pet.vo.Member;
import bitcamp.pet.vo.UpPhoto;

@Controller
@RequestMapping("/ajax/upphoto/")
public class UpPhotoAjaxController {

  @Autowired
  UpPhotoService upphotoService;
  
  @Autowired
  ServletContext servletContext;

  @RequestMapping(value = "putImg", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
  public String putImg(MultipartFile[] img, HttpSession session) throws ServletException, IOException {
    Member member = ((Member)session.getAttribute("loginUser"));
    UpPhoto upphoto = new UpPhoto();
    int pno = member.getMno();
    File dir = new File("img/photos/" + member.getEmail());
    
    if (!dir.exists()) {
      dir.mkdirs();
    }
    
    String realPath = servletContext.getRealPath("img/photos/" + member.getEmail()+"/");
    
    for (int i = 0; i < img.length; i++) {
      int extPoint = img[i].getOriginalFilename().lastIndexOf(".");
      String filename = System.currentTimeMillis() + img[i].getOriginalFilename().substring(extPoint);

      //  String path = upphoto.getBoardPicPath() + filename;
      //  String path = servletContext.getRealPath("img/boardImg/" + filename);
      
      String dbpath = "img/photos/" + filename;

      HashMap<String, Object> result = new HashMap<>();
      try {
        upphotoService.add(dbpath, pno);
        List<String> imgPath = upphotoService.getImg(pno);
        img[i].transferTo(new File(path));
        result.put("list", imgPath);
        result.put("status", "success");
      } catch (Exception e) {
        result.put("status", "failure");
      }
    }
    return "redirect:../../freeRead.html?bno=" + bno;
    
  }
    
    @RequestMapping(value="getImg", produces="application/json;charset=UTF-8", method=RequestMethod.GET)
    @ResponseBody
    public String getImg(int pno, HttpSession session) 
        throws ServletException, IOException {
       HashMap<String,Object> result = new HashMap<>();
       try {
         List<String> imgPath = boardService.getImg(pno);
        result.put("list", imgPath);
         result.put("status", "success");
     }catch(Exception e) {
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
*/