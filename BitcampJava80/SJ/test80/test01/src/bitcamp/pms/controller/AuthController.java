package bitcamp.pms.controller;

import java.util.Scanner;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;
import bitcamp.pms.domain.Student;
import bitcamp.pms.domain.Teacher;
import bitcamp.pms.util.CommandUtil;
import bitcamp.pms.util.Session;

@Controller
public class AuthController {
  final static String telFormat = "^(\\d{2,4}-)?(\\d{3,4})-(\\d{4})";
  final static String passwordFormat = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@?])[a-zA-Z0-9!@?]{4,10}$";
  final static String emailFormat = "[\\w\\.]*@[\\w]*\\.[a-zA-Z]*";
  private Scanner keyScan;
  private MemberDao memberDao;
  private Session session;

  public void setSession(Session session) {
    this.session = session;
  }

  public void setMemberdao(MemberDao memberdao) {
    this.memberDao = memberdao;
  }

  public void setScanner(Scanner scanner) {
    keyScan = scanner;
  }

  @RequestMapping("logout")
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
        System.out.println("안녕히 가세요!");
        System.exit(0);
      default:
        System.out.println("올바르지 않은 명령어입니다.");
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
    int no;
    System.out.println("직업을 선택하세요.");
    while (true) {
      System.out.println("1.강사 2.매니저 3.수강생");
      try {
        System.out.print("직업? ");
        no = Integer.parseInt(keyScan.nextLine());
        if (no > 3 || no < 1) {
          System.out.println("1 ~ 3을 선택해주세요.");
          continue;
        }
        break;
      } catch (Exception e) {
        System.out.println("숫자로 선택해 주세요.");
      }
    }
    member.setAuth(no);
    while (true) {
      System.out.print("이름? ");
      check = keyScan.nextLine();
      if ("".equals(check)) {
        System.out.println("이름은 반드시 적어야합니다.");
        continue;
      }
      member.setNm(check);
      break;
    }
    
    System.out.print("주소? ");
    member.setAddre(keyScan.nextLine());

    while (true) {
      System.out.print("전화? ");
      check = keyScan.nextLine();
      if (check.matches(telFormat))
        break;
      else
        System.out.println("전화 번호 형식에 맞지 않습니다.(3~4-4자), (2~4-3~4-4)");
    }
    member.setTel(check);

    System.out.print("사진? ");
    member.setPhoto(keyScan.nextLine());

    while (true) {
      System.out.print("이메일? ");
      check = keyScan.nextLine();
      // if(memberDao.selectOne(check) != null)
      // System.out.println("중복된 이메일 입니다. 다른 이메일을 정해주세요.");
      if (check.matches(emailFormat))
        break;
      else
        System.out.println("이메일 형식이 맞지 않습니다. (유효 형식: xxx@xxx.xxx)");
    }
    member.setEmail(check);

    while (true) {
      System.out.print("암호? ");
      check = keyScan.nextLine();
      if (check.length() < 4 || check.length() > 10)
        System.out.println("암호는 4 ~ 10자 까지만 가능합니다. ");
      else if (check.matches(passwordFormat))
        break;
      else
        System.out.println("최소 알파벳1개, 숫자1개, 특수문자(?,!,@)만 1개 반드시 포함");
    }
    member.setPwd(check);
    memberDao.insert(member);
    switch (no) {
    case 1:
      System.out.print("담당과정? ");
      check = keyScan.nextLine();
      Teacher tch = new Teacher();
      tch.setClas(check);
      break;
    case 2:
      
      break;
    case 3:
      Student std = new Student();
      while (true) {
        System.out.print("교육과정? ");
        check = keyScan.nextLine();
        if ("".equals(check)) {
          System.out.println("교육과정은 반드시 적어야합니다.");
          continue;
        }
        std.setCour(check);
        break;
      }
      System.out.print("졸업여부(y/n)? ");
      std.setGrd(keyScan.nextLine());
      while (true) {
        System.out.print("재직여부(y/n)? ");
        check = keyScan.nextLine();
        if ("".equals(check)) {
          System.out.println("재직여부는 반드시 적어야합니다.");
          continue;
        }
        std.setWork(keyScan.nextLine());
        break;
      }
      while (true) {
        System.out.print("기수(ex. java80)? ");
        check = keyScan.nextLine();
        if ("".equals(check)) {
          System.out.println("기수는 반드시 적어야합니다.");
          continue;
        }
        std.setCnt(check);
        break;
      }
    }
    System.out.println("회원가입성공.");
  }
  
  private void doLogin() {
    String email = null;
    String password = null;
    Member member = new Member();
    while (true) {
      System.out.print("이메일: ");
      email = keyScan.nextLine();
      member = memberDao.selectOne(email);
      if (member == null) {
        System.out.println("등록되지 않은 사용자입니다.");
      } else {
        break;
      }
    }
    while (true) {
      System.out.print("암호: ");
      password = keyScan.nextLine();
      if (member.getPwd().equals(password)) {
        System.out.printf("환영합니다. %s님!\n", member.getNm());
        session.setAttribute("loginUser", member);
        break;
      } else {
        System.out.println("암호가 맞지 않습니다.");
      }
    }
  }

  @RequestMapping("unsubscribe")
  public void doUnSubscribe(Session se) {
    try {
      if (CommandUtil.confirm(keyScan, "정말 탈퇴하시겠습니까?")) {
        memberDao.delete(((Member) se.getAttribute("loginUser")).getMemd());
        System.out.println("탈퇴가 완료되었습니다. 안녕히가세요.");
        System.exit(0);
      } else {
        System.out.println("탈퇴를 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }
}
