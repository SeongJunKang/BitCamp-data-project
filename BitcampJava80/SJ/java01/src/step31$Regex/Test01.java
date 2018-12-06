package step31$Regex;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    String regex = "abc";
//    String regex = "a\\b\\c";
    String input = null;
    while (true) {
      input = keyScan.nextLine();
      if (input.equals("quit")) {
        break;
      }
      System.out.println(input.matches(regex));
    }
    keyScan.close();
  }
}
