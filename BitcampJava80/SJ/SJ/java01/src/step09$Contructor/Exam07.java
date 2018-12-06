// 주제 :  인스턴스  초기화 문장.
//  생성자와 인스턴스 초기화 블록을 사용하지 않고
//        인스턴스 변수를 초기화 하는 방법
package step09$Contructor;

public class Exam07 {

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
    void sum() {//국영수 합계를 계산하는 연산하
      this.sum = this.kor+ this.eng + this.math;
    }
    void aver() {
      this.avr = this.sum / 3f;
    }
  }

  public static void main(String[] args) {

      Score s = new Score("홍길동",100,90,80);
      s.sum();    //s 데이터에 대해 sum() 연산을 연산을 실행한다.
      s.aver();   //s 데이터에 대해 aver() 연산을 연산을 실행한다.
      System.out.printf("%s %d %d %d %d %.2f \n", s.name, s.kor, s.eng, s.math, s.sum, s.avr);
  }
}

/*
* 메서드 ?
- 특정 기능을 수행하는 명령어를 묶어 둔 것
- 사용자가 정의한 타입(클래스)의 데이터를 다루는 연산자를 정의할 떄
  메서드 문법을 사용한다. --> method == operator
- 메서드 실행은 물건에게 명령을 내리기 위해
  메시지를 전달하는 것과 같다. -->method == message
*/
