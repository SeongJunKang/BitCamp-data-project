// 주제 : class 로 사용자 정의타입 만들기
package step09$Contructor;

public class Exam02 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float avr;
  }

  public static void main(String[] args) {

    Score[] s = new Score[3];

    for (int i = 0; i < s.length ; i++ ) {
      s[i]= new Score();
    }

    s[0].name = "홍길동";
    s[0].kor = 100;
    s[0].eng = 90;
    s[0].math = 100;

    s[1].name= "임꺽정";
    s[1].kor = 90;
    s[1].eng = 90;
    s[1].math = 80;

    s[2].name = "유관순";
    s[2].kor = 100;
    s[2].eng = 100;
    s[2].math = 100;

    for (int i = 0 ; i < s.length ; i++ ) {
      s[i].sum = s[i].kor + s[i].eng + s[i].math;
      s[i].avr = s[i].sum / 3f;
    }

    for ( int i = 0  ; i < s.length ; i ++ ) {
      System.out.printf("%s : %d, %d, %d  - sum :%d , avr : %.2f \n",s[i].name,s[i].kor,s[i].eng,s[i].math,s[i].sum,s[i].avr);
    }

  }
}


/*


*/
