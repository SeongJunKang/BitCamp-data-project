// 주제 :  인스턴스  초기화 문장.
//  생성자와 인스턴스 초기화 블록을 사용하지 않고
//        인스턴스 변수를 초기화 하는 방법
package step09$Contructor;

public class Exam06 {

  static class Score {
    String name = "오호라";    //인스턴스 변수 선언 + 초기화 문장
    int kor=50;
    int eng=50;
    int math=50;
    int sum=0;
    float avr=50f;

    { // 인스턴스 초기화 블럭
        name = "우헤헤";
    }

    Score(){
        sum=kor+eng+math;
    }

  }


  public static void main(String[] args) {

      Score s = new Score();
      System.out.printf("%s %d %d %d %d %.2f \n",s.name,s.kor,s.eng,s.math,s.sum,s.avr);
  }
}

/*
* 인스턴스 생성 후 초기화 작업 순서
1) 인스턴스 초기화 문장 실행
2) 인스턴스 초기화 블록 실행
3) 생성자 실행

*/
