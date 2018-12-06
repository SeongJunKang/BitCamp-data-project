package step31$Regex;

import java.util.Scanner;

public class Test05 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
//    String regex = "^a\\d";           //a,0~9 문자.
//    String regex = "^\\p{Alpha}\\w";    //알파벳 문자로 시작, 알파벳문자또는 숫자.
    String regex = "\\wx$";             // 알파벳문자 또는 숫자로 시작해서, x 로 끝남.
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
