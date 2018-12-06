package step36;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect  // 다음 클래스가 AOP 필터 클래스임을 선언한다.
public class TestAdvice {
  
  // PointCut
  // => 어느 메서드에 꼽을 것인지 지정한다.
  // => 필터 실행 옵션
  //    execution("리턴타입 메서드패턴(파라미터패턴)")
  @Before("execution(* *.ArithmeticCalculator.*(..))")
  public void before(// <== Advice : 특정 패턴의 메서드를 호출하기 전에 실행될 메서드
      JoinPoint joinPoint // <== 필터링 대상이 되는 메서드 정보
      ) { 
    System.out.println("TestAdvice.before()...");
    System.out.printf("    대상 메서드: %s\n", joinPoint.getSignature().getName());
  }
  
  @After("execution(* *.ArithmeticCalculator.*(..))")
  public void after(JoinPoint joinPoint) { 
    System.out.println("TestAdvice.after()...");
    System.out.printf("    대상 메서드: %s\n", joinPoint.getSignature().getName());
  }
  
  // @AfterReturning은 메서드가 호출된 후 리턴 값이 무엇인지 알아낼 수 있다.
  @AfterReturning(
      pointcut="execution(* *.ArithmeticCalculator.*(..))",  // 어느 메서드에 대해 필터를 꼽을 지 지정.
      returning="result" // 리턴 값은 어떤 변수에 꼽을 지 지정. 
      )
  public void afterReturning(JoinPoint joinPoint, Object result) { 
    System.out.println("TestAdvice.afterReturning()...");
    System.out.printf("    대상 메서드: %s\n", joinPoint.getSignature().getName());
    System.out.printf("    리턴 값: %f\n", result);
  }
}







