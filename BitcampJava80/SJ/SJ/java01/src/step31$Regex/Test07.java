package step31$Regex;

import java.util.Scanner;

public class Test07 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
//    String regex = "ab";      // 연속 문자열 검사 a --> b
//    String regex = "a|b";     // a 또는 b
    String regex = "(a|b)(x|y)";    // (a 또는 b) 다음 (x 또는 y)
    String input = null;                
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("quit")) {
        break;
      }
      System.out.println(input.matches(regex));
    }
    keyScan.close();
  }
}
