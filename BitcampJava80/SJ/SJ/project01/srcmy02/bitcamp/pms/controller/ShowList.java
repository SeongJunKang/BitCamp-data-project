package bitcamp.pms.controller;
import java.util.Scanner;
import bitcamp.pms.domain.Member;
import bitcamp.pms.dto.MemberController;




public class ShowList {

  public static void ShowList() {
    for ( int i = 0  ; i < MemberController.cnt ; i ++ ) {
      System.out.println(i +" " + MemberController.members[i].toString());
    }
  }
}
