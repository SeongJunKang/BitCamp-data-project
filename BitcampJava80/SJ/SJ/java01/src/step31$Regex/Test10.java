package step31$Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test10 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    // \\b --> 스페이스로 구분
//    Pattern pattern = Pattern.compile("\\babc\\b"); // 1) 정규식으로 패턴 선언
    Pattern pattern = Pattern.compile("\\b\\d{4}-\\d{1,2}-\\d{1,2}\\b"); // 1) 정규식으로 패턴 선언
    Matcher matcher = null;

    String input = null;

    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("quit"))
        break;
      matcher = pattern.matcher(input); // 2) 입력 문자열을 정규식에 따라 분석할 객체를 얻는다.
      while (matcher.find()) {
        System.out.println(matcher.group());
      }
    }

    keyScan.close();
  }

}
