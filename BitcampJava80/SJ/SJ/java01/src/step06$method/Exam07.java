/* 가변 개수의 파라미터 선언순서 ?.
*/
package step06$method;

public class Exam07 {

  // 가변 개수 파라미터는 반드시 마지막에 선언해야 한다.
  static int plus(String s,int... a) {
//  static int plus(int... a,String s) {
    //파라미터 값 꺼내기 --> 배열처럼 사용
    int sum = 0 ;
    for (int v : a) {
      sum += v;
    }
    return sum;
  }
  public static void main(String[] args) {
    System.out.println(plus("문자열"));
    System.out.println(plus("문자열",10));
    System.out.println(plus("문자열",100));
    System.out.println(plus("문자열",10,20,50,60,71,80,90,100));
  }
}

/*

*/
