package bitcamp.pms.controller;
import bitcamp.pms.dao.MemberController;
import java.util.Scanner;

public class ConfirmInt {

    static Scanner keyScan = new Scanner(System.in);
  public static String ScanInt(){

    ConfirmInt.keyScan = MemberController.keyScan;
    MemberController.str = MemberController.keyScan.next();
    return MemberController.str;
  }

  public static boolean CheckInt(String str){

    if((char)MemberController.str.charAt(0) > 95){
      return true;
    }else {
      return false;
    }
  }
}
