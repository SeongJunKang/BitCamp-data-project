package bitcamp.pms.controller;

import java.util.Scanner;

import bitcamp.pms.ProjectApp;
import bitcamp.pms.annotation.Controller;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Controller
public class AuthController {
  final static String telFormat ="^(\\d{2,4}-)?(\\d{3,4})-(\\d{4})";
  final static String passwordFormat ="^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@?])[a-zA-Z0-9!@?]{4,10}$";
  final static String emailFormat ="[\\w\\.]*@[\\w]*\\.[a-zA-Z]*";
  private Scanner keyScan;
  public String email;
  public int selectedNo;
  
  public String getEmail() {
    return email;
  }

  public int getSelectedNo() {
    return selectedNo;
  }

  private String password;
  private MemberDao memberDao;
  public void setMemberdao(MemberDao memberdao) {
    this.memberDao = memberdao;
  }

  public void setScanner(Scanner scanner) {
    keyScan = scanner;
  }

  public void service() {
    String input = "";
    while (true) {
      input = loginPrompt();
      switch (input) {
      case "1":
        doLogin();
        return;
      case "2":
        doSighUp();
        break;
      case "3":
        ProjectApp.doQuit();
        System.exit(0);
      default:
        ProjectApp.doError();
      }
    }
  }

  private String loginPrompt() {
    System.out.println("1) 로그인");
    System.out.println("2) 회원가입");
    System.out.println("3) 종료");
    System.out.print("선택> ");
    return keyScan.nextLine().toLowerCase();
  }

  private void doSighUp() {
    Member member = new Member();
    String check = null;
    System.out.print("이름? ");
    member.setName(keyScan.nextLine());
    while (true) {
      System.out.print("이메일? ");
      check = keyScan.nextLine();
      if (check.matches(emailFormat)) {
        member.setEmail(check);
        break;
      } else {
        System.out.println("이메일 형식이 맞지 않습니다. (유효 형식: xxx@xxx.xxx)");
      }
    }

    while (true) {
      System.out.print("암호? ");
      check = keyScan.nextLine();
      if (check.matches(passwordFormat)) {
        member.setPassword(check);
        break;
      } else {
        System.out.println("암호는 4 ~ 10자 까지만 가능합니다. " + "최소 알파벳1개, 숫자1개, 특수문자(?,!,@)만 1개 반드시 포함");
      }
    }

    do {
      System.out.print("전화? ");
      check = keyScan.nextLine();
      if (check.matches(telFormat)) {
        member.setTel(check);
      } else {
        System.out.println("전화 번호 형식에 맞지 않습니다.(3~4-4자), (2~4-3~4-4)");
      }
    } while (!check.matches(telFormat));
    memberDao.insert(member);
  }

  private void doLogin() {
    
    Member member = new Member();
    System.out.print("이메일: ");
    email = keyScan.nextLine();
    System.out.print("암호: ");
    password = keyScan.nextLine();
    member = memberDao.selectOne(email);
    if (member == null) {
      System.out.println("등록되지 않은 사용자입니다.");
    } else if (member.getPassword().equals(password)) {
      System.out.printf("환영합니다. %s님!\n", member.getName());
      selectedNo = member.getNo();
      return;
    } else {
      System.out.println("암호가 맞지 않습니다.");
    }
  }
}
