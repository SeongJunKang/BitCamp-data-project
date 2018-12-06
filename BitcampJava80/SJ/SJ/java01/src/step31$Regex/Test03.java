package step31$Regex;

import java.util.Scanner;

public class Test03 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
//    String regex = "[abc]"; 
//    String regex = "[^abc]";
//    String regex = "[a-z]";
//    String regex = "[a-zA-Z]"; 
//    String regex = "[a-d[x-z]"; // a | b | c | d | x | y | z 중 한개.
    String regex = "[a-f&&[d-m]]";  // 두개의 교집합. d e f  
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
