package bitcamp.pms.dto;
import java.util.Scanner;
import bitcamp.pms.domain.Member;


public class MemberController {

  public static Scanner keyScan = new Scanner(System.in);
  public static Member[] members = new Member[100];
  public static int cnt;
  public static String[] info = new String[4];
  public static String str;





  public static String ScanInt(){
    str = keyScan.next();
    return str;
  }

  public static boolean CheckInt(String str){

    if((char)str.charAt(0) > 95){
      return true;
    }else {
      return false;
    }
  }

  
  //
  // public static void PrintOnlyNum(){
  //   System.out.print("숫자만 입력하세요.");
  // }
  // public static void PrintCancle(){
  //   System.out.print("취소되었습니다.");
  // }

    // public static void ShowList() {
    //   for ( int i = 0  ; i < cnt ; i ++ ) {
    //     System.out.println(i +" " + members[i].toString());
    //   }
    // }
  //
  // public static void InsertData(int index, String arg1,
  // String arg2, String arg3 , String arg4) {
  //   members[index].setName(arg1);
  //   members[index].setEmail(arg2);
  //   members[index].setPassword(arg3);
  //   members[index].setTel(arg4);
  // }



  // public static void DoAbout() {
  //   System.out.println("비트캠프 자바 80기 회원관리 시스템");
  // }
  // public static void DeleteMem() {
  //   System.out.print("삭제할 회원 번호 : ");
  //   int delnum = 0;
  //   if(CheckInt(ScanInt())) {
  //    PrintOnlyNum();
  //   } else{
  //      delnum = Integer.parseInt(str);
  //      if(MessageConfirm.Confirm("정말삭제하시겠습니까 (y/n):").equals("y")) {
  //        System.out.println("삭제되었습니다.");
  //        DoDelete(delnum);
  //        InsertData(--cnt,null,null,null,null);
  //      }else {
  //        PrintCancle();
  //      }
  //   }
  // }
  //
  // public static void DoDelete(int del){
  //   for(int i = del ; i < cnt - 1 ; i++ ) {
  //     members[i] = members[i + 1];
  //   }
  // }

  // public static void UpdateMem() {
  //   System.out.print("업데이트할 회원 번호 : ");
  //   int updatenum = 0;
  //   if(CheckInt(ScanInt())) {
  //    PrintOnlyNum();
  //   } else{
  //      updatenum = Integer.parseInt(str);
  //      if(updatenum > cnt) {
  //        System.out.println("회원수가 더 적습니다.");
  //      } else {
  //        DoInput();
  //        if(MessageConfirm.Confirm("정말 업데이트 하시겠습니까 ? (y/n):").equals("y")) {
  //          InsertData(updatenum,info[0],info[1],info[2],info[3]);
  //        } else {
  //          PrintCancle();
  //        }
  //      }
  //   }
  // }
  // public static void Addmem() {
  //   String[] info = new String[4];
  //   MemberController.DoInput();
  //   if(MessageConfirm.Confirm("저장하시겠습니까 ? (y/n) :").equals("y")) {
  //     System.out.println("저장되었습니다.");
  //     members[cnt++] = new Member(info[0] , info[1] ,info[2] ,info[3]);
  //   } else {
  //     MemberController.PrintCancle();
  //   }
  // }
}
