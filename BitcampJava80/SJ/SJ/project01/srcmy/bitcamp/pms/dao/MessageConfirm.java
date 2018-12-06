package bitcamp.pms.dao;
import java.util.Scanner;
import bitcamp.pms.domain.Member;
import bitcamp.pms.dao.MemberController;

public class MessageConfirm {
  static Scanner keyScan = new Scanner(System.in);
  public static String Confirm(String message) {

    MessageConfirm.keyScan = MemberController.keyScan ;
    String cmds;
    System.out.print(message);
    while(true) {
      cmds = keyScan.nextLine();
      if(message.equals("명령 > ")) {
        cmds = cmds.toLowerCase();
        switch(cmds) {
        case "add" :
        return "add";
        case "quit" :
        return "quit";
        case "list" :
        return "list";
        case "delete" :
        return "delete";
        case "update" :
        return "update";
        case "about" :
        return "about";
        case "go member" :
        return "member";
        case "go project" :
        return "project";
        default :
        PrintErr(message);
        }
      }else {
        if(cmds.equals("y")) {
          return "y";
        } else if(cmds.equals("n")) {
          return "n";
        } else {
          PrintErr(message);
         }
      }
    }

  }

  static void PrintErr(String message){
    System.out.print("잘못된 명령어입니다. \n");
    System.out.print(message);
  }

}
