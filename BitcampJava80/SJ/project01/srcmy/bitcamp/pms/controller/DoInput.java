package bitcamp.pms.controller;

import bitcamp.pms.dao.MemberController;
import bitcamp.pms.dao.MessageConfirm;
import java.util.Scanner;

public class DoInput {

    static Scanner keyScan = new Scanner(System.in);
  public static void DoInput() {

    DoInput.keyScan = MemberController.keyScan ;

    String[] index = new String[]{"이름 : ","이메일 : ","암호 : ","전화 : "};
    for(int i = 0 ; i < index.length ; i ++){
      System.out.println(index[i]);
      MemberController.info[i] = keyScan.next();
    }
  }

}
