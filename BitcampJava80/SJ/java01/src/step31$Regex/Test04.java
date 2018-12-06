package step31$Regex;

import java.util.Scanner;

public class Test04 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
//    String regex = "[0-9]"; // 0~ 9 까지의 숫자를 의미
//    String regex = "\\d";     // 0~ 9 까지의 숫자를 의미.
//    String regex = "[a-zA-Z_0-9]";    10~11번째 줄 같은의미.
//    String regex = "\\w";
//    String regex = ".";   //모든문자 한개.
    String regex = "\\."; // . 문자 한개.
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
