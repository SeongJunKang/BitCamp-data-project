/*
여러개의 매서드 정의하기
*/
package step06$method;

public class Exam05 {


  static int plus(int a, int b) {
    return a + b;
  }
  static int minus(int a, int b) {
    return a - b;
  }
  static int multiple(int a, int b) {
    return a * b;
  }
  static float divide(int a, int b) {
    return (float)a / (float)b;
  }
  public static void main(String[] args) {

    System.out.println(plus(10,20));
    System.out.println(minus(10,20));
    System.out.println(multiple(10,5));
    System.out.println(divide(10,2));
  }
}

/*

*/
