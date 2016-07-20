package bitcamp.pet.controller.ajax;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

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
    Member member = ((Member) session.getAttribute("loginUser"));
    HashMap<String, Object> result = new HashMap<>();
    int pno = member.getMno();
    String dirPath = servletContext.getRealPath("/img/photos/" + member.getEmail());
    File dir = new File(dirPath); 
    if (!dir.exists()) {
      dir.mkdirs();
    }

    String realPath = servletContext.getRealPath("img/photos/" + member.getEmail() + "/");

    for (int i = 0; i < img.length; i++) {
      int extPoint = img[i].getOriginalFilename().lastIndexOf(".");
      if (extPoint > 0) {
        String filename = img[i].getOriginalFilename();
        try {
          img[i].transferTo(new File(realPath + filename));
          UpPhoto upphoto = new UpPhoto();
          upphoto.setPno(pno);
          upphoto.setPtos(filename);
          upphotoService.add(upphoto);
          result.put("status", "success");
        } catch (Exception e) {
          result.put("status", "failure");
        }
      }
    }
    return "redirect:../../mypage/testmypage3.html";
  }
}
