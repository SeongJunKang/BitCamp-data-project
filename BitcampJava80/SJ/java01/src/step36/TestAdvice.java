package step36;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 다음 클래스가 AOP 필터 클래스임을 선언.
public class TestAdvice {

  // 포인트컷
  // 어느 메서드에 꼽을것인지 지정.
  // 필터 실행 옵션
  // execution("리턴타입 메서드(파라미터)")
  @Before("execution(* *.ArithmeticCalculator.*(..))")
  public void before(JoinPoint joinPoint) { // << Advice : 특정 패턴의 메서드를 호출하기 전에
                                            // 실행시킬 메서드.
    System.out.println("=>TestAdvice.before()");
    System.out.println("    대상 메서드 " + joinPoint.getSignature().getName());
  }

  // << Advice : 특정 패턴의 메서드를 호출후에 실행시킬 메서드.
  @After("execution(* *.ArithmeticCalculator.*(..))")
  public void after(JoinPoint joinPoint) {
    System.out.println("=>TestAdvice.after()");
    System.out.println("    대상 메서드 " + joinPoint.getSignature().getName());
  }

  // << Advice : 메서드가 호출된 후 메서드 리턴 값이 무엇인지 알아낼 수 있다.
  @AfterReturning(pointcut = "execution(* *.ArithmeticCalculator.*(..))", returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    System.out.println("=>TestAdvice.afterReturning()");
    System.out.println("    대상 메서드: " + joinPoint.getSignature().getName());
    System.out.println("    리턴값: " + result);
  }
}
