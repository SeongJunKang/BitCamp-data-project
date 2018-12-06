package bitcamp.pms.dto;

import bitcamp.pms.controller.AddMem;
import bitcamp.pms.controller.DeleteMem;
import bitcamp.pms.controller.ShowList;
import bitcamp.pms.controller.UpdateMem;
import bitcamp.pms.controller.QuitProgram;
import bitcamp.pms.controller.DoAbout;

public class PlayManagement {

  public static void PlayManagement() {
    String check;
    while(true){
      check = MessageConfirm.Confirm("명령 > ");
      switch(check) {
      // case "add" :
    //   AddMem.Addmem();
    //   break;
      // case "list" :
    //   ShowList.ShowList();
    //   break;
      // case "delete" :
    //   DeleteMem.DeleteMem();
    //   break;
      // case "update" :
    //   UpdateMem.UpdateMem();
    //   break;
      case "go member" :
      System.out.println("회원관리 >");
      break;
      case "go project" :
      System.out.println("프로젝트관리 >");
      break;
      case "quit" :
      QuitProgram.Quit();
      break;
      case "about" :
      DoAbout.DoAbout();
      break;
      }
      if(check.equals("quit")) {
        break;
      }

    }

  }

}
