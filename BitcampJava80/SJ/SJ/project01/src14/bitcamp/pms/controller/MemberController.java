package bitcamp.pms.controller;

import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import bitcamp.pms.domain.Member;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
public class MemberController implements MenuController {
  private static final String filename = "member.data";
  private Scanner keyScan ;
  private ArrayList<Member> members ;

  public MemberController() {
    members = new ArrayList<Member>();
  }
  public void load(){
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);
      String text;
      String[] values;
      Member member;
      while ( (text = in.readLine()) != (null) ) {
        values = text.split(",");
        member = new Member(values[0],values[1],values[2],values[3]);
        members.add(member);
      }
      in0.close();
      in.close();
    } catch (Exception e){
    }
  }

  
  
  @Override
  public String toString() {
    return  "member";
  }
  @Override
  public void destroy() {
    try {
      this.save();
    } catch(Exception e){}
  }

  @Override
  public void init() {
    this.load();
  }

  @Override
  public void service(Map<String,Object> paramMap) {
    System.out.println("---------------회원관리에 오신걸 환영합니다.------------");
    keyScan = (Scanner)paramMap.get("stdin");
    String input;
    do {
      input = prompt();
      processService(input);
    } while (!input.equals("main"));
  }

  public void save() throws Exception {
    FileWriter out0 = new FileWriter(filename);
    BufferedWriter out1 = new BufferedWriter(out0);
    PrintWriter out = new PrintWriter(out1);

    for (Member member : members) {
      out.println(member);
    }

    out.close();
    out1.close();
    out0.close();
  }

  public String prompt() {
    System.out.print("회원관리 > ");
    return keyScan.nextLine().toLowerCase();
  }

  private void processService(String input) {
    try{
      if (input.equals("add")) {
        doAdd();
      } else if (input.equals("update")) {
        doUpdate();
      } else if (input.equals("list")) {
        doList();
      } else if (input.equals("delete")) {
        doDelete();
      } else if (input.equals("main")) {
        doMain();
      } else {
        doError();
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("인덱스가 유효범위를 벗어났습니다.");
    } catch (Exception e) {
      System.out.println("잘못된 명령어 입니다.");
    }
  }

  private void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  private void doAdd() {
    Member member = new Member();

    System.out.print("이름? ");
    member.setName(keyScan.nextLine());

    System.out.print("이메일? ");
    member.setEmail(keyScan.nextLine());

    System.out.print("암호? ");
    member.setPassword(keyScan.nextLine());

    System.out.print("전화? ");
    member.setTel(keyScan.nextLine());

    if (confirm("저장하시겠습니까?", true)) {
      members.add(member);
      System.out.println("저장하였습니다.");
    } else {
      System.out.println("저장을 취소하였습니다.");
    }
  }

  private void doUpdate() {
    System.out.print("변경할 회원 번호는? ");

    int no = Integer.parseInt(keyScan.nextLine());

    if( no >= members.size() || no < 0) {
      doCheckNo();
      return;
    } else {
      // Member oldMember = members.get(no);
      Member member = new Member() ;

      System.out.printf("이름(%s)? ", members.get(no).getName());
      member.setName(keyScan.nextLine());

      System.out.printf("이메일(%s)? ", members.get(no).getEmail());
      member.setEmail(keyScan.nextLine());

      System.out.printf("암호(%s)? ", members.get(no).getPassword());
      member.setPassword(keyScan.nextLine());

      System.out.printf("전화(%s)? ", members.get(no).getTel());
      member.setTel(keyScan.nextLine());

      if (confirm("변경하시겠습니까?", true)) {
        members.set(no, member);
        System.out.println("변경하였습니다.");
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    }
  }

  private void doList() {
    for (int i = 0; i < members.size(); i++) {
      System.out.println(i + " " + members.get(i));
    }
  }

  private void doMain() {
    System.out.println("----------------메인화면 입니다.--------------");
  }

  private void doDelete() {
    System.out.print("삭제할 회원 번호는? ");
    int no = Integer.parseInt(keyScan.nextLine());
    if (confirm("정말 삭제하시겠습니까?", true)) {
      members.remove(no);
      System.out.println("삭제하였습니다.");
    } else {
      System.out.println("삭제를 취소하였습니다.");
    }
  }

  private boolean confirm(String message, boolean strictMode) {
    String input = null;
    do {
      System.out.printf("%s(y/n) ", message);
      input = keyScan.nextLine().toLowerCase();

      if (input.equals("y")) {
        return true;
      } else if (input.equals("n")) {
        return false;
      } else {
        if (!strictMode) {
          return false;
        }
        System.out.println("잘못된 명령어입니다.");
      }
    } while(true);
  }

  private void doCheckNo() {
    if (members.size() != 0) {
      System.out.printf("회원 번호가 잘못되었습니다. (0 ~ %d)\n", members.size() - 1);
    } else {
      System.out.println("등록된 회원이 없습니다.");
    }
  }
}
