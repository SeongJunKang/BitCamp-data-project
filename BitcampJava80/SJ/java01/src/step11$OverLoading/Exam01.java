/* 주제 : 생성자 오버로딩

*/

package step11$OverLoading;



public class Exam01 {
  public static void main(String[] args) {

      Score s = new Score("홍길동",100,90,100);
      s.setKor(50);

      System.out.printf("%s %d %d %d %d %.2f \n", s.getName(), s.getKor(), s.getEng(),
       s.getMath(), s.getSum(), s.getAver());

      Score s2 = new Score();
      s2.setName("임꺽정");
      s2.setKor(100);
      s2.setEng(80);
      s2.setMath(90);

      System.out.printf("%s %d %d %d %d %.2f \n", s2.getName(), s2.getKor(), s2.getEng(),
       s2.getMath(), s2.getSum(), s2.getAver());

  }
}

/*
 * 오버로딩 ?
 -비록 파라미터가 다르더라도 같은 기능을 수행하는 메서드에 대해 같은 이름을 부여함으로써
  프로그래밍의 일관성을 확보하는 기능이다.


*/
