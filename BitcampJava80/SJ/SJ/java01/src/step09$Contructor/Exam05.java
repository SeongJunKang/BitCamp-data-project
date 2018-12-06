// 주제 :또 다른 인스턴스 초기화 문법 인스턴스 초기화 블록
//
package step09$Contructor;

public class Exam05 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float avr;

    { // 인스턴스 초기화 블럭
        System.out.println("인스턴스 초기화 블럭 1");
    }
    Score(String name, int kor, int eng, int math){
        System.out.println("생성자호출");
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    { // 인스턴스 초기화 블럭
        System.out.println("인스턴스 초기화 블럭 2");
    }
  }


  public static void main(String[] args) {
      new Score("홍길동",100,100,100 );

      Object anonymousObj = new Object() {
        public String toString() {
          return "오호라 익명 객체";
        }

        {
          System.out.println("오호라, 익명개체 초기화");
        }
      };

  }
}

/*
* 인스턴스 초기화 블록
- 생성자처럼 인스턴스가 생성될 때 마다 실행되는 블록
- 생성자가 있는데 왜 이 문법이 필요한가?
  언제 사용하는가 ?
        ->생성자가 없는 클래스에 초기화 명령을 실행하고 싶을 때.
*/
