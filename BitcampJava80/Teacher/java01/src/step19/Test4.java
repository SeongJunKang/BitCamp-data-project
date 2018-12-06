// 주제: 예외 객체의 다형성
package step19;

public class Test4 {
  public static void main(String[] args) {
    Calculator1 calc = new Calculator1();
    calc.plus(10);

    try {
      calc.divide(0);
      System.out.println("----------------");
      System.out.println(calc.result);
      System.out.println("----------------");
    //} catch (ArithmeticException e) { // 본인
    //} catch (RuntimeException e) {  // 부모
    //} catch (Exception e) { // 조부모
    } catch (Throwable e) { // 증조부모
    //} catch (Object e) { // 문법 오류!
                        // 다형적 변수를 사용하더라도
                        // Throwable까지만 사용할 수 있다.
                        // => catch()의 파라미터는 오직
                        //    Throwable 타입만 허용된다.
      System.out.println("나누기 오류 발생!");
      System.out.println(e.getMessage()); // 간단한 오류 정보
      System.out.println("----------------------");
      e.printStackTrace(); // 완전한 오류 정보
    }
  }
}

/*
# 예외 정보를 다루는 클래스
- java.lang.Throwable 클래스이다.
- 모든 예외 클래스는 Throwable의 자손이다.
- Throwable의 하위 클래스
1) Error
  => JVM이 발생시키는 예외이다.
  => 프로그램의 실행을 더이상 지속할 수 있는 상태가 아니다.
    종료하기 전에 적절한 조치를 취하라.
  => 프로그램에서 적절한 조치를 할 수 없다.
     개발자가 처리할 상황이 아니다.
2) Exception
  => 프로그램에서 발생하는 예외이다.
  => 개발자는 이 예외를 처리하는 코드를 반드시 작성해야 한다.
     왜? JVM을 멈추지 않고 계속 실행해야 하기 때문이다.
  => RuntimeException
     - RuntimeException은 비록 Exception의 하위 클래스이지만,
       이 예외는 반드시 처리할 필요가 없다.
     - 만약 개발자가 이 예외를 처리하는 코드를 작성하지 않는다면,
       기본으로 JVM이 처리할 것이다.
       JVM이 어떻게 처리한다고? 즉시 실행을 멈춘다.
*/
