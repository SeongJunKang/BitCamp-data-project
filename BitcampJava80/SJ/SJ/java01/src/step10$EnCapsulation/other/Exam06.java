/* 주제 : 다른 패키지의 클래스 사용법

*/

package step10$EnCapsulation.other;
import step10$EnCapsulation.Score4;

public class Exam06 {
  public static void main(String[] args) {

      Score4 s = new Score4("홍길동",100,90,100);
      s.setKor(50);

      System.out.printf("%s %d %d %d %d %.2f \n", s.getName(), s.getKor(), s.getEng(),
       s.getMath(), s.getSum(), s.getAver());
  }
}
