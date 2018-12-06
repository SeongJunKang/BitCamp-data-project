package bitcamp.pms.controller;

import java.util.*;
import java.io.*;
import java.lang.IndexOutOfBoundsException;
import bitcamp.pms.domain.Member;
import bitcamp.pms.annotation.Component;

@Component("member")
public class MemberController implements MenuController {
  static final String filename = "member.data";
  Scanner keyScan;
  ArrayList<Member> members;

  public MemberController ( ) {
    members = new ArrayList<>();
  }

  @Override
  public void init () {
    try{
    FileReader in0 = new FileReader(filename);
    BufferedReader in = new BufferedReader(in0);

    String line;
    String[] values;
    Member member;
    while((line = in.readLine())!=null) {
      values = line.split(",");
      member = new Member(values[0], values[1], values[2], values[3]);
      members.add(member);
    }
    in.close();
    in0.close();
  }catch(Exception e) {
    System.out.println("데이터 로딩 실패");
  }
  }
  @Override
  public void destroy() {
    try{
    FileWriter out0 = new FileWriter(filename);
    BufferedWriter out1 = new BufferedWriter(out0);
    PrintWriter out = new PrintWriter(out1);


    for (Member member : members){
      out.println(member);
    }


    out.close();
    out1.close();
    out0.close();
  } catch(Exception e) {
    System.out.println("데이터 저장 실패");
  }
  }




public String prompt() {
    System.out.print("회원관리> ");
    return keyScan.nextLine().toLowerCase();
  }
  @Override
  public void service(Map<String,Object> paramMap) {
    keyScan = (Scanner)paramMap.get("stdin");
    String input="";
    while (!input.equals("main")) {
      try {
    input = prompt();
    if(input.equals("add")) {
      doAdd();
    } else if(input.equals("update")) {
      doUpdate();
    } else if (input.equals("delete")) {
      doDelete();
    } else if (input.equals("list")) {
      doList();
    } else if(input.equals("main")){
    } else {
      System.out.println("잘못된 명령입니다.");
    }
  } catch(IndexOutOfBoundsException e){
    System.out.println("유효한 인덱스가 아닙니다.");
  } catch (Exception e) {
    System.out.println("오류발생 !");
  }
  }
  }
  public void doAdd() {
     Member member = new Member();
     System.out.print("이름? ");
     member.setName(keyScan.nextLine());
     System.out.print("이메일? ");
     member.setEmail(keyScan.nextLine());
     System.out.print("암호? ");
     member.setPassword(keyScan.nextLine());
     System.out.print("전화? ");
     member.setTel(keyScan.nextLine());


     if (confirm("저장하시겠습니까")) {
       members.add(member);
       System.out.println("저장되었습니다.");
     } else {
       System.out.println("저장이 취소되었습니다.");
     }

  }
    public void doUpdate() {
         Member member = new Member();
         System.out.print("변경하실 회원 번호? ");
         int no = Integer.parseInt(keyScan.nextLine());
         System.out.printf("이름(%s)? ",members.get(no).getName());
         member.setName(keyScan.nextLine());
         System.out.printf("이메일(%s)? ",members.get(no).getEmail());
         member.setEmail(keyScan.nextLine());
         System.out.printf("암호(%s)? ",members.get(no).getPassword());
         member.setPassword(keyScan.nextLine());
         System.out.printf("전화(%s)? ",members.get(no).getTel());
         member.setTel(keyScan.nextLine());


         if (confirm("변경하시겠습니까")) {
           members.set(no,member);
           System.out.println("변경되었습니다.");
         } else {
           System.out.println("변경이 취소되었습니다.");
         }
    }
      public void doDelete() {
        System.out.print("삭제하실 회원 번호? ");
        int no = Integer.parseInt(keyScan.nextLine());
        if (confirm("삭제하시겠습니까")) {
          members.remove(no);
          System.out.println("삭제되었습니다.");
        } else {
          System.out.println("삭제가 취소되었습니다.");
        }
      }
        public void doList() {
            for(int i = 0; i < members.size(); i++) {
              System.out.printf("%d, %s\n", i, members.get(i).toString());
            }
        }

          public boolean confirm(String msg) {
            System.out.printf("%s (y/n)? ",msg);
            String input;
            while(true){

              input = keyScan.nextLine().toLowerCase();
              if(input.equals("y")) {
                return true;
              } else if(input.equals("n")) {
                return false;
              } else {
                System.out.print("다시 입력하세요. ");
              }

            }
          }









}
