package step31$Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test12 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    // (?=검색패턴)대상패턴
//    Pattern pattern = Pattern.compile("(?=abc)abcok");
//    Pattern pattern = Pattern.compile("(?=\\d)");    //숫자 한개를 찾아라. 
                                                //단, 값을 캡쳐하지는 말아라.
//    Pattern pattern = Pattern.compile("(?=\\d)\\d");    //숫자 한개를 찾아라.
                                                //그 숫자값을 캡쳐하라.
    Pattern pattern = Pattern.compile(
        "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@?])[a-zA-Z0-9!@?]{4,12}");
    //마지막에 개수.
    Matcher matcher = null;
    String input = null;
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("0"))
        break;
      matcher = pattern.matcher(input); // 2) 입력 문자열을 정규식에 따라 분석할 객체를 얻는다.
      while (matcher.find()) {
        System.out.printf("%d ~ %d : %s \n",matcher.start(),matcher.end(),matcher.group());
        System.out.println(matcher.end()-matcher.start() + " : " + input.length());
      }
    }

    keyScan.close();
  }

}
