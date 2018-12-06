// 주제 : 캡슐화 적용 후

package step10$EnCapsulation;

public class Exam02 {


  public static void main(String[] args) {

      Score s = new Score("홍길동",100,90,100);

      //외부에서 접근할때 ?
      //s.kor = 120;

      s.summ();
      s.aver();
      //외부에서 접근할때 ?
      //s.sum = 88;       // 컴파일 오류 발생

      //인스턴스 변수에 직접 접근할 수 없기 때문에
      // 다음과 같이 명령어를 작성할 수 없다.
      // System.out.printf("%s %d %d %d %d %.2f \n", s.name, s.kor, s.eng, s.math, s.sum, s.avr);
      System.out.printf("%s %d %d %d %d %.2f \n", s.getName(), s.getKor(), s.getEng(),
       s.getMath(), s.getSumm(), s.getAver());
  }
}

/*
* 격리 레벨을 높이면 값을 꺼낼 수 없다.
해결책 : 값을 넣고 꺼내주는 연산자 ( 메소드 ) 를 추가하라.
-값을 꺼낸 연산자. - 겟터(getter)
  int getkor() {} => getXxxx()
-값을 설정하는 연산자. - 셋터(setter)
  void setkor(int value){} => setXxx()

*/

/*
* 개선점 : 현재 스코어는 인스턴스를 생성할 때 값을 저장할 수 있다.
- 인스턴스를 생성한 후에는 값을 변경할 수 없다.
- 모든 변수가 private 으로 접근 레벨이 높아졌기 때문이다.
- 해결책 값을 설정해주는 연산자를 추가하라.

*/
