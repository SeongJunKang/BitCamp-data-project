package step31$Regex;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    // 정규식(정규표현식 ;Regular Expression)에서 역실래시를 문자로 사용하려면
    // "\\"이렇게 지정해야 한다.
    // regex "a\\b\\c" --> "a\b\c"
    String regex = "a\\\\b\\\\c"; // 정규표현식 오류!
    // 이유 ?
    // 자바 문자열에서 \\ 는 '\' 문자 하나를 의미.
    // 만약 두개의 역슬래쉬 문자를 표현하고 싶다면,
    // "\\\\" 이렇게 해야한다.
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
