package step31;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test12 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    // (?=검색패턴)대상패턴
    //Pattern pattern = Pattern.compile("(?=abc)abcok");
    //=> 숫자 1개를 찾아라. 단 값을 캡쳐하지는 말아라!
    //Pattern pattern = Pattern.compile("(?=\\d)");
    //=> 숫자 1개를 찾아라. 값을 캡쳐하라!
    //Pattern pattern = Pattern.compile("(?=\\d)\\d");
    //=> 숫자 1개 포함, 대소문자 1개 포함, 특수문자(!@?) 1개 포함
    //   단 숫자,대소문자,!@? 문자만 사용할 수 있다. 
    //Pattern pattern = Pattern.compile(
    //    "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@?])[0-9a-zA-Z!@?]{개수}");
    
    Pattern pattern = null;
    Matcher matcher = null;
    
    String input = null;
    String regex = null;
    
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("quit"))
        break;
      
      regex = String.format(
        "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@?])[0-9a-zA-Z!@?]{%d}", input.length());

      pattern = Pattern.compile(regex);
      matcher = pattern.matcher(input); // 2) 입력 문자열을 정규식에 따라 분석할 객체를 얻는다.
      
      if (matcher.find()) { // 3) 분석 시작
        System.out.println(matcher.group()); // 찾은 값을 리턴 
      }
    }
    
    keyScan.close();
  }

}










