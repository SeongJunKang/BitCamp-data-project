package bitcamp.pms.controller;
import java.util.Scanner;
import bitcamp.pms.domain.Member;
import bitcamp.pms.dto.MemberController;
import bitcamp.pms.dto.MessageConfirm;
public class UpdateMem {

  public static void UpdateMem() {
    System.out.print("업데이트할 회원 번호 : ");
    int updatenum = 0;
    if(MemberController.CheckInt(MemberController.ScanInt())) {
     PrintSentence.PrintOnlyNum();
    } else{
       updatenum = Integer.parseInt(MemberController.str);
       if(updatenum > MemberController.cnt) {
         System.out.println("회원수가 더 적습니다.");
       } else {
         DoInput.DoInput();
         if(MessageConfirm.Confirm("정말 업데이트 하시겠습니까 ? (y/n):").equals("y")) {
           InsertData.InsertData(updatenum,MemberController.info[0],
           MemberController.info[1],MemberController.info[2],MemberController.info[3]);
         } else {
           PrintSentence.PrintCancle();
         }
       }
    }
  }
}
