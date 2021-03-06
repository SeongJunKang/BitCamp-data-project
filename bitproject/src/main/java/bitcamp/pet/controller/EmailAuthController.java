package bitcamp.pet.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import bitcamp.pet.service.MemberService;
import bitcamp.pet.vo.Member;

@Controller
@RequestMapping("/email/")
public class EmailAuthController {
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="auth")
  @ResponseBody
  public String emailAuth(HttpSession httpsession){
          Properties p = System.getProperties();
          p.put("mail.smtp.starttls.enable", "true");     // gmail은 무조건 true 고정
          p.put("mail.smtp.host", "smtp.gmail.com");      // smtp 서버 주소
          p.put("mail.smtp.auth","true");                 // gmail은 무조건 true 고정
          p.put("mail.smtp.port", "587");                 // gmail 포트
          Authenticator auth = new MyAuthentication();
          //session 생성 및  MimeMessage생성
          Session session = Session.getDefaultInstance(p, auth);
          MimeMessage msg = new MimeMessage(session);
          HashMap<String, Object> result = new HashMap<>();
          try{
              //편지보낸시간
              msg.setSentDate(new Date());
              InternetAddress from = new InternetAddress("DogWalker <walkwithdog@gmail.com>");
              msg.setFrom(from);                                               // 이메일 발신자
              Member member = ((Member)httpsession.getAttribute("loginUser"));
              InternetAddress to = new InternetAddress(member.getEmail());// 이메일 수신자
              msg.setRecipient(Message.RecipientType.TO, to);
              msg.setSubject(member.getName()+"님, 산책할개 이메일 인증 입니다", "UTF-8");          // 이메일 제목
              msg.setText("안녕하세요. "+member.getName() +"님,"
                  + "<a href = 'http://192.168.0.64:8080/bitproject/main/index.html'>산책할개</a> "
                  + "에 인증하시려면 아래의 링크를 클릭해주세요.<br> "
                  + "<a href='http://192.168.0.64:8080/bitproject/email/complete.do?mno="+member.getMno()+"'>인증하기</a>", "UTF-8");                                    // 이메일 내용
              msg.setHeader("content-Type", "text/html");                      // 이메일 헤더
              javax.mail.Transport.send(msg);                                  // 메일보내기
              result.put("status", "이메일 인증 대기중");
          }catch (AddressException addr_e) {
              result.put("status", "이메일 전송 실패 ");
              addr_e.printStackTrace();
          }catch (MessagingException msg_e) {
              result.put("status", "이메일 전송 실패 ");  
              msg_e.printStackTrace();
          }
          return new Gson().toJson(result);
      }
  
  @Autowired
  MemberService memberService;
  
    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8", value = "complete")
    public String update(int mno,HttpSession session,Model model) throws ServletException, IOException {
      Member member = (Member) session.getAttribute("loginUser");
      if (member == null) {
        model.addAttribute("type","warning");
        model.addAttribute("eauth","산책할개에 로그인을 먼저 해주세요.");
        return "email/EmailAuth";
      }
      
      if ( member.getMno() != mno) {
        model.addAttribute("type","error");
        model.addAttribute("eauth","올바르지않은 경로입니다.");
        return "email/EmailAuth";
      }
      
      try {
        if (member.getEauth().equals("인증")) {
          model.addAttribute("type","error");
          model.addAttribute("eauth","이미 처리된 인증 정보입니다.");
          return "email/EmailAuth";
        }
      } catch (Exception e) {
      }
      member.setEauth("인증");
      
      try {
        memberService.change(member); // 회원정보 변경 신청
        model.addAttribute("type","success");
        model.addAttribute("eauth","산책할개에 오신걸 환영합니다. 인증 성공했습니다.");
        return "email/EmailAuth";
      } catch (Exception e) {
        e.printStackTrace();
      }
      model.addAttribute("type","error");
      model.addAttribute("eauth","실패했습니다. 잠시 후 다시 시도해주세요");
      return "email/EmailAuth";
    }
  }


   
  class MyAuthentication extends Authenticator {
      PasswordAuthentication pa;
      public MyAuthentication(){
          String id = "";       // 구글 ID
          String pw = "";                  // 구글 비밀번호
          // ID와 비밀번호를 입력한다.
          pa = new PasswordAuthentication(id, pw);
      }
      // 시스템에서 사용하는 인증정보
      public PasswordAuthentication getPasswordAuthentication() {
          return pa;
      }
}
