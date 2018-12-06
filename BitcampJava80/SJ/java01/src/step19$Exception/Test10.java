// 주제 : RuntimeException 의 이해 ~ 상위 호출자에게 자동 전달
package step19$Exception;

public class Test10 {

  static void m1() {
    m2();
  }

  static void m2() {
    m3();
  }

  static void m3() {
    throw new RuntimeException();
  }

  public static void main(String[] args) {
    try{
      m1();
    } catch (RuntimeException e) {
      System.out.println("예외처리");
    }
  }

}


/*
*/
