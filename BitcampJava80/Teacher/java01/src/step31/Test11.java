package step31;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test11 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    // (?<이름>패턴)
    Pattern pattern = Pattern.compile(
        "\\b((?<year>\\d{4})-(?<month>\\d\\d?)-(?<day>\\d\\d?))\\b");
    
    Matcher matcher = null;
    
    String input = null;
    
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("quit"))
        break;
      matcher = pattern.matcher(input); // 2) 입력 문자열을 정규식에 따라 분석할 객체를 얻는다.
      while (matcher.find()) { // 3) 분석 시작
        System.out.printf("%s, %s, %s, %s\n", 
            matcher.group(), 
            matcher.group("year"), 
            matcher.group("month"), 
            matcher.group("day")); // 찾은 값을 리턴 
      }
    }
    
    keyScan.close();
  }

}










