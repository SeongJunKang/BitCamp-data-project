package bitcamp.pms.dto;
import java.util.Scanner;
import bitcamp.pms.domain.Member;
import bitcamp.pms.dto.MemberController;

public class MessageConfirm {
  static Scanner keyScan = new Scanner(System.in);

  public static String Confirm(String message) {

    MessageConfirm.keyScan = MemberController.keyScan ;
    String str;
    System.out.print(message);
    while(true) {
      str = keyScan.nextLine();
      if(message.equals("명령 > ")) {
        str=str.toLowerCase();
        switch(str) {
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
         return "go member";
        case "go project" :
         return "go project";
        default :
          PrintErr(message);
        }
      }else {
        if(str.equalsIgnoreCase("y")) {
          return "y";
        } else if(str.equalsIgnoreCase("n")) {
          return "n";
        } else {
          PrintErr(message);
         }
      }
    }
  }

  public static void PrintErr(String message){
    System.out.print("잘못된 명령어입니다. \n");
    System.out.print(message);
  }

}
