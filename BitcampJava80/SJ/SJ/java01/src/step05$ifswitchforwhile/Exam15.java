/*주제 : break와 continue*/
package step05$ifswitchforwhile;

public class Exam15{

  public static void main(String[] args){
    for (int i = 0; i < 10; i++) {
      if(i==5)
        break;      //즉시 반복문을 멈춘다.
      System.out.println(i);
    }
    System.out.println("----------------------------------");
    //continue  -> 특정 조건에해당하는 항목을 건너 뛰고 싶을 떄.
    for (int i = 0; i < 10; i++) {
      if(i==5)
        continue;      //다음 문장을 실행하지 않고 증가/감소 문으로 이동.
      System.out.println(i);
    }
  }
}
