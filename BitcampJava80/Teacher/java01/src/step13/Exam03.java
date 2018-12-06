// 주제: 날짜 데이터를 다루는 클래스
package step13;

import java.util.Date;

public class Exam03 {
  public static void main(String[] args) {
    Date today = new Date(); // 인스턴스에는 오늘 날짜와 시간이 들어 있다.

    // println(레퍼런스)
    // => println()은 레퍼런스에 대해 toString()을 실행한 후
    //    그 리턴 값을 출력한다.
    System.out.println(today);
    System.out.println(today.toString()); // 위의 코드와 같다.


  }
}
