/* 가변 개수의 파라미터 선언하기.
*/
package step06$method;

public class Exam06 {

  // 가변 개수 파라미터는 int 값을 0 개 이상 받을 수 있다.
  static int plus(int... a) {
    //파라미터 값 꺼내기 --> 배열처럼 사용
    int sum = 0 ;
    for (int v : a) {
      sum += v;
    }
    return sum;
  }
  public static void main(String[] args) {
    System.out.println(plus());
    System.out.println(plus(10));
    System.out.println(plus(10,100));
    System.out.println(plus(10,20,50,60,71,80,90,100));
  }
}

/*

*/
