package bitcamp.pms0.controller;

import java.util.Scanner;
import java.util.ArrayList;
import bitcamp.pms0.domain.Member;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
public class MemberController {
  private static final String filename = "member.data";
  Scanner scan = new Scanner(System.in);
  ArrayList<Member> members;
  public MemberController(){
    members = new ArrayList<>();
  }

  public void load() {
    try{
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);
      String value = null;
      String[] splits;
      Member member;
      while( (value = in.readLine()) != null ) {
        splits = value.split(",");
        member = new Member(splits[0],splits[1],splits[2],splits[3]);
        members.add(member);
      }

    } catch (Exception e){}
  }

  public void save() {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0);
      PrintWriter out = new PrintWriter(out1);

      for (Member m : members ) {
        out.println(m);
      }
      out.close();
      out1.close();
      out0.close();
    } catch(Exception e){}
  }

  public void memberService(){
    String input=null;
      do {
        try{
          System.out.print("회원관리 > ");
          input = scan.nextLine().toLowerCase();
          switch(input) {
          case "add":
          doAdd();
          break;
          case "update":
          doUpdate();
          break;
          case "main":
          System.out.println("메인화면으로 돌아갑니다.");
          break;
          case "delete":
          doDelete();
          break;
          case "list":
          for (int i = 0; i < members.size() ; i++ ) {
            System.out.println(i + ","+ members.get(i).toString());
          }
          break;
          default :
          System.out.println("유효하지않은 명령입니다.");
          break;
        }
      }catch (Exception e) {
        System.out.println("유효하지않은 명령입니다.");
      }
    }  while (!input.equals("main"));
  }

  public void doDelete() {
    Member member = new Member();
    System.out.print("삭제하실 번호를 적어주세요 :");
    int no = Integer.parseInt(scan.nextLine());
    System.out.println(no +","+members.get(no).toString());
    if (confirm("정말 삭제하시겠습니까 ?")) {
      members.remove(no);
      System.out.println("삭제되었습니다.");
    } else {
      System.out.println("삭제 취소되었습니다.");
    }
  }

  public boolean confirm(String msg) {
    System.out.printf("%s (y/n) : ",msg);
    String input = null;
    while (true) {
      input = scan.nextLine().toLowerCase();
      if (input.equals("y")) {
        return true;
      } else if (input.equals("n")) {
        return false;
      } else {
        System.out.print("다시 입력하세요.(y/n) : ");
      }
    }
  }
  public void doAdd() {
    Member member = new Member();
    System.out.print("이름 : ");
    member.setName(scan.nextLine());
    System.out.print("이메일 : ");
    member.setEmail(scan.nextLine());
    System.out.print("비밀번호 : ");
    member.setPassword(scan.nextLine());
    System.out.print("전화번호 : ");
    member.setTel(scan.nextLine());
    if (confirm("정말 저장하시겠습니까 ?")) {
      members.add(member);
      System.out.println("저장되었습니다.");
    } else {
      System.out.println("저장 취소되었습니다.");
    }
  }
  public void doUpdate() {
    Member member = new Member();
    System.out.print("변경하실 번호를 적어주세요 :");
    int no = Integer.parseInt(scan.nextLine());
    System.out.printf("이름 (%s):",members.get(no).getName());
    member.setName(scan.nextLine());
    System.out.printf("이메일 (%s): ",members.get(no).getName());
    member.setEmail(scan.nextLine());
    System.out.printf("비밀번호 (%s): ",members.get(no).getName());
    member.setPassword(scan.nextLine());
    System.out.printf("전화번호 (%s): ",members.get(no).getName());
    member.setTel(scan.nextLine());
    if (confirm("정말 변경하시겠습니까 ?")) {
      members.set(no,member);
      System.out.println("변경되었습니다.");
    } else {
      System.out.println("변경 취소되었습니다.");
    }
  }

}
