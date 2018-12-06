/* 가변 개수의 파라미터 선언문법 - 여러개 ? 
*/
package step06$method;

public class Exam08 {

  // 다음과 같이 여러개 만들 수 없다.
  static int plus(String s,int... a) {
//  static int plus(int... a,boolean... b) {
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
