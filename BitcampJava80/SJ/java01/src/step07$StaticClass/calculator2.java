/* 사칙연산 메서드를 별도로 모아둔다.*/
package step07$StaticClass;
public class calculator2 {
  static int result ;
  // 클래스 공용변수 => 클래스 변수 , 스태틱 변수
  // 이 클래스의 모든 메서드가 사용하는 변수.
  // 굳이 초기화 시키지 않아도 0으로 초기화
  // 클래스의 메서드가 공유하는 값을 저장할 때 사용한다.
  static void plus(int b) {
    result += b;
  }
  static void minus(int b) {
    result -= b;
  }
  static void multiple(int b) {
    result *= b;
  }
  static void divide(int b) {
    result /= b;
  }
}
