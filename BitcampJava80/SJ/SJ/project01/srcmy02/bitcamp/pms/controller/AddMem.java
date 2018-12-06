package bitcamp.pms.controller;
import java.util.Scanner;
import bitcamp.pms.domain.Member;
import bitcamp.pms.dto.MemberController;
import bitcamp.pms.dto.MessageConfirm;


public class AddMem {

  public static void Addmem() {
    DoInput.DoInput();
    if(MessageConfirm.Confirm("저장하시겠습니까 ? (y/n) :").equals("y")) {
      System.out.println("저장되었습니다.");
      MemberController.members[MemberController.cnt++] = new Member(
      MemberController.info[0] , MemberController.info[1] ,
      MemberController.info[2] , MemberController.info[3]);
    } else {
      PrintSentence.PrintCancle();
    }
  }

}
