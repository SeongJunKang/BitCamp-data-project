package bitcamp.pms.controller;
import java.util.Scanner;
import bitcamp.pms.dto.MemberController;

public class InsertData {

  public static void InsertData(int index, String arg1,
  String arg2, String arg3 , String arg4) {
    MemberController.members[index].setName(arg1);
    MemberController.members[index].setEmail(arg2);
    MemberController.members[index].setPassword(arg3);
    MemberController.members[index].setTel(arg4);
  }
}
