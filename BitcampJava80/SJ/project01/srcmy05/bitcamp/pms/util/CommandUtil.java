package bitcamp.pms.util;

import java.util.Scanner;

public class CommandUtil {

  public static boolean confirm(String message, Scanner keyScan) {
    String input = null;
    do {
      System.out.printf("%s(y/n) ", message);
      input = keyScan.nextLine().toLowerCase();

      if (input.equals("y")) {
        return true;
      } else if (input.equals("n")) {
        return false;
      } else {
        System.out.println("잘못된 명령어입니다.");
      }
    } while(true);
  }
}
