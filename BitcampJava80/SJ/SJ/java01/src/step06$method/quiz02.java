/*
값을 리턴하는 메서드 정의하기
*/
package step06$method;

public class quiz02 {

  static int CircleOfNumbers(int a , int b) {
    return ( a /2 + b ) % a;
  }
  public static void main(String[] args) {

    System.out.println(CircleOfNumbers(10,3));
  }
}

/*

*/
