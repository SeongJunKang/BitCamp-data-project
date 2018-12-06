
package bitcamp.pms.controller;
import java.util.Scanner;
import bitcamp.pms.domain.Member;
import bitcamp.pms.dto.MemberController;
import bitcamp.pms.dto.MessageConfirm;

public class DeleteMem {
  public static void DeleteMem() {
    System.out.print("삭제할 회원 번호 : ");
    int delnum = 0;
    if(MemberController.CheckInt(MemberController.ScanInt())) {
     PrintSentence.PrintOnlyNum();
    } else{
       delnum = Integer.parseInt(MemberController.str);
       if(MessageConfirm.Confirm("정말삭제하시겠습니까 (y/n):").equals("y")) {
         System.out.println("삭제되었습니다.");
         DoDelete(delnum);
         InsertData.InsertData(--MemberController.cnt,null,null,null,null);
       }else {
         PrintSentence.PrintCancle();
       }
    }
  }

  public static void DoDelete(int del){
    for(int i = del ; i < MemberController.cnt - 1 ; i++ ) {
      MemberController.members[i] = MemberController.members[i + 1];
    }
  }
}
