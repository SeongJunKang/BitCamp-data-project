// 주제 : 캡슐화 적용 전

package step10$EnCapsulation;

public class Exam01 {

  static class Score {
    String name ;
    int kor;
    int eng;
    int math;
    int sum;
    float avr;

    Score(String name, int kor, int eng, int math){
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
    }
    void summ() {//국영수 합계를 계산하는 연산하
      this.sum = this.kor+ this.eng + this.math;
    }
    void aver() {
      this.avr = this.sum / 3f;
    }
  }

  public static void main(String[] args) {

      Score s = new Score("홍길동",100,90,100);
                      //특정항목에 대해 유효 범위를 넘어가는 값을 저장
     s.kor = 120;    //문법은 ok, but 의미는 작업은 무효.

      s.summ();
      s.aver();
                      //특정 항목의 값을 임의로 변경
     s.sum = 88;     //문법은 ok , 작업은 무효하다.
                      //위 코드가 문법적으로는 문제가 없지만, 유효한 명령인가 ?
     System.out.printf("%s %d %d %d %d %.2f \n", s.name, s.kor, s.eng, s.math, s.sum, s.avr);
  }
}

/*
* 무효한 값을 설정할 떄 ?
- 문법 상으로는 문제가 없지만, 프로그램 또는 작업의 목적에 부합하지 않는 경우가 발생한다.
- 이런 문제가 발생한 이유 ?
   1) 인스턴스 변수에 임의적으로 접근할 수 있기 때문.
   2) 내부에서 사용되어야할 명령어가 외부에서 사용할 때.
- 해결책 ?
  ->외부로부터 변수나 메서드에 대해 격리시키기.
    ==> 캡슐화( encapsulation)
- 캡슐화 격리 레벨
1) private : 내부에서만 접근 가능
2) public : 완전 공개
3) default : 같은 패키지에 소속된 클래스에서는 접근 가능
4) protected : 같은 패키지 + 자식들



*/
