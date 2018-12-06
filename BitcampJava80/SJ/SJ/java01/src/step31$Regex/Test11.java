package step31$Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test11 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    // (?<이름> 패턴)
    Pattern pattern = Pattern.compile("\\b(?<year>\\d{4})-"
        + "(?<month>\\d{1,2})-(?<day>\\d{1,2})\\b"); // 1) 정규식으로 패턴 선언
    Matcher matcher = null;

    String input = null;

    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("0") )
        break;
      matcher = pattern.matcher(input); // 2) 입력 문자열을 정규식에 따라 분석할 객체를 얻는다.
      while (matcher.find()) {
        System.out.printf("%s,\t%s,\t%s,\t%s\n",matcher.group(),matcher.group("year")
            ,matcher.group("month"),matcher.group("day"));
      }
    }

    keyScan.close();
  }

}
