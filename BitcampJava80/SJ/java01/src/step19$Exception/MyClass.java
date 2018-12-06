package step19$Exception;


public class MyClass {

  public void m1() {
    // 호출자에게 예외를 던진다.
    // Throw 에게 예외를 던진다.
    throw new RuntimeException("No !");
  }

  public void m2() throws Exception {
    // 호출자에게 Exception 예외를 던진다.
    /*
    - Exception 예외는 반드시 메서드 선언부에 어떤 예외를 던지는지 명시해야 한다.
    - void 메서드명 throws 예외1, 예외2 , {....}
    */

    throw new Exception("룰루랄라");
  }
}
