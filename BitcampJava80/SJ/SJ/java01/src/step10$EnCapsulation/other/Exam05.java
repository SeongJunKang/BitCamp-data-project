/* 주제 : 다른 패키지의 클래스 사용법

*/

package step10$EnCapsulation.other;
import step10$EnCapsulation.Score3;


public class Exam05 {
  public static void main(String[] args) {

      Score3 s = new Score3("홍길동",100,90,100);
      s.setKor(50);

      System.out.printf("%s %d %d %d %d %.2f \n", s.getName(), s.getKor(), s.getEng(),
       s.getMath(), s.getSum(), s.getAver());
  }
}

/*
  * 다른 패키지 클래스 사용법
   1) 클래스 이름앞에 패키지 이름을 모두 적어라.
      -> step10.Score3 s = new step10.Score3("홍길동",100,90,100);
   2) import를 사용하여 패키지 선언 밑에 클래스의 패키지 정보를 등록한다.
      -> import step10.Score3;
      -> import step10.*;  <----(비추천) : 클래스의 소속을 직관적으로 알 수 없다.

    문제 : 컴파일할 때 오류 발생.
    - Score3 클래스의 접근 레벨이 (default)이기 때문이다.
    - default 는 오직 같은 패키지에 소속된 클래스만이 접근할 수 있다.
    - Exam05 는 Score3와 다른 패키지에 소속되었기 때문에 Score3에 접근할 수 없다.
    해결책 : Score3의 클래스 접근 레벨을 public 공개하면 된다.
    -> Score4 참조

*/
