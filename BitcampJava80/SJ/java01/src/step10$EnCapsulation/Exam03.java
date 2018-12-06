// 주제 : 캡슐화 적용 후 2

package step10$EnCapsulation;

public class Exam03 {


  public static void main(String[] args) {

      Score2 s = new Score2("홍길동",100,90,100);
      // 셋터를 이용하면 인스턴스를 생성한 후에도 값을 변경할 수 있다.
      // 또한 셋터 내부에서 값을 저장하기 전에 값의 유효 여부를 검사할 수 있다.
      //-> 무효한 값이 저장되는것을 막을 수 있다.
      //-> 셋터의 존재이유.
      s.setKor(120);    // 무효한 점수이기 때문에 저장안됨.
      s.setEng(60);
      //s.summ(); // 성적을 변경할 때 마다 합계와 평균이 자동 계산이 되기 때문에
      //s.aver(); // 다음 명령은 필요가 없다.

      System.out.printf("%s %d %d %d %d %.2f \n", s.getName(), s.getKor(), s.getEng(),
       s.getMath(), s.getSum(), s.getAver());
  }
}

/*

*/
