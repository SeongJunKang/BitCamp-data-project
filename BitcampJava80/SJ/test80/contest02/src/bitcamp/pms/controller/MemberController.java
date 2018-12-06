package bitcamp.pms.controller;

import java.util.Scanner;
import java.util.ArrayList;
import bitcamp.pms.domain.Member;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.lang.IndexOutOfBoundsException;
public class MemberController {
  final static String filename = "member.data";
  Scanner scan = new Scanner(System.in);
  ArrayList<Member> members ;

  public  MemberController() {
    members = new ArrayList<>();
  }

  public void load() {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);

      String line;
      String[] values;
      Member member;
      while ((line = in.readLine()) != null){
        values = line.split(",");
        member = new Member(values[0],values[1],values[2],values[3]);
        members.add(member);
      }
      in.close();
      in0.close();
    } catch (Exception e) {

    }
  }
  public void save() {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0);
      PrintWriter out = new PrintWriter(out1);

      for (Member member : members) {
        out.println(member);
      }

      out.close();
      out1.close();
      out0.close();
    } catch (Exception e) {

    }

  }

  public void service() {

    String input = null;

    do {
      try{
        System.out.print("회원관리> ");
        input = scan.nextLine().toLowerCase();
        switch (input) {
          case "add":
            doAdd(); break;
          case "update":
            doUpdate(); break;
          case "list":
            doList(); break;
          case "delete":
            doDelete(); break;
          case "main":
            break;
          default:
            System.out.println("잘못된 명령어입니다.");
        }
      } catch(IndexOutOfBoundsException e){
        System.out.println("유효하지 않은 인덱스 입니다.");
      }
    }while(!input.equals("main"));
  }

  public boolean confirm(String msg){
    while (true) {
      System.out.printf("%s(y/n) ",msg);
      String input= scan.nextLine().toLowerCase();
      if(input.equals("y")) {
        return true;
      } else if (input.equals("n")) {
        return false;
      } else {
        System.out.println("잘못 입력했습니다.");
      }
    }
  }

  public void doAdd() {
    Member member = new Member();

    System.out.printf("이름? ");
    member.setName(scan.nextLine());
    System.out.printf("이메일? ");
    member.setEmail(scan.nextLine());
    System.out.printf("암호? ");
    member.setPassword(scan.nextLine());
    System.out.printf("전화? ");
    member.setTel(scan.nextLine());

    if (confirm("저장하시겠습니까? ")) {
      members.add(member);
      System.out.println("저장했습니다.");
    } else {
      System.out.println("저장 취소했습니다.");
    }
  }
  public void doUpdate() {
    Member member = new Member();
    System.out.print("변경하실 회원 번호? ");
    int no = Integer.parseInt(scan.nextLine());

    System.out.printf("이름(%s)? ",members.get(no).getName());
    member.setName(scan.nextLine());
    System.out.printf("이메일(%s)? ",members.get(no).getEmail());
    member.setEmail(scan.nextLine());
    System.out.printf("암호(%s)? ",members.get(no).getPassword());
    member.setPassword(scan.nextLine());
    System.out.printf("전화(%s)? ",members.get(no).getTel());
    member.setTel(scan.nextLine());

    if (confirm("변경하시겠습니까? ")) {
      members.set(no,member);
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }
  }

 public void doDelete() {
   System.out.print("삭제하실 회원 번호? ");
   int no = Integer.parseInt(scan.nextLine());

   if (confirm("삭제하시겠습니까? ")) {
     members.remove(no);
     System.out.println("삭제했습니다.");
   } else {
     System.out.println("삭제 취소했습니다.");
   }
 }

 public void doList() {
   for (int i = 0; i < members.size(); i++) {
     System.out.printf("%d, %s\n", i, members.get(i).toString());
   }
 }

}
