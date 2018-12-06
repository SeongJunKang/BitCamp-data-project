// 주제 : 메서드 접근 레벨
// 메서드는 보통 외부에서 접근할 수 있도록 개방한다. => public 으로 선언
// 그러나 메서드 중에서 내부에서만 써야하는 경우, 인스턴스 변수처럼
// 격리 레벨을 올린다. -> private 등.

package step10$EnCapsulation;

public class Exam04 {


  public static void main(String[] args) {

      Score2 s = new Score2("홍길동",100,90,100);
      s.setKor(50);

      // Score2 에서 sum() 과 aver() 의 접근 레벨이 default 이기 때문에
      // 같은 패키지에 속해 있는 모든 클래스에서 사용 가능했다.
      // Score3 에서는 두 메소드 모두 private 레벨을 갖기 때문에
      // 다음과 같이 외부에서 사용할 수 없다.

      System.out.printf("%s %d %d %d %d %.2f \n", s.getName(), s.getKor(), s.getEng(),
       s.getMath(), s.getSum(), s.getAver());
  }
}

/*
  * 캡슐화?
  - 클래스의 용도에 맞게끔 내부 멤버(변수와 메서드)의 접근 레벨을 조정하는 문법이다.
  - 잘못된 접근을 차단함으로써 클래스 오용을 막을 수 있다.
*/
