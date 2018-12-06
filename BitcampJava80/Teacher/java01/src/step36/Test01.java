// 주제: AOP 필터 적용
package step36;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step36/application-context.xml");

    printAllBeanInfo(context);
    
    ArithmeticCalculator calc1 = (ArithmeticCalculator)context.getBean("calc1");
    System.out.printf("10 + 20 = %f\n", calc1.plus(10, 20));
    System.out.printf("10 - 20 = %f\n", calc1.minus(10, 20));
    
    UnitCalculator calc2 = (UnitCalculator)context.getBean("calc2");
    System.out.printf("95 kg --> %f lb\n", calc2.kilogramToPound(95));
    
  }

  private static void printAllBeanInfo(ApplicationContext context) {
    String[] names = context.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(context.getBean(name).getClass().getName());
    }
    System.out.println("-----------------------------------");
  }

}
/*
# AOP(Aspect-Oriendted Programming; 관점 지향 프로그래밍)
=> 메서드 호출 앞 뒤로 필터를 꼽는 기술
=> 제약사항: 스프링 IoC 컨테이너에서 관리하는 객체에 한에 필터를 꼽을 수 있다.
=> 용어
"PointCut"    : 필터를 꼽을 대상을 지정
"Advice"      : 필터
"JoinPoint"  : 대상이 되는 메서드 정보  

# AOP 사용법
1) 스프링 설정 파일에 AOP 관련 애노테이션을 처리할 빈을 추가한다.
   => 다음은 AOP 관련 애노테이션을 처리할 빈 클래스를 간접적으로 등록하는 태그다.
   <aop:aspectj-autoproxy/>
2) AOP 관련 애노테이션을 처리할 클래스가 들어 있는 라이브러리를 추가한다.
   => build.gradle 파일에 다음 의존 라이브러리를 추가하고, gradle을 실행하라!
   compile 'org.springframework:spring-aop:4.3.0.RC2'
   compile 'org.aspectj:aspectjweaver:1.8.9'
3) Advice를 실행할 필터 클래스를 준비한다.
   => TestAdvice
   
# AOP 필터링 의미
1) @Before : 메서드 호출 전
2) @After : 메서드 호출 후
3) @AfterReturning : 값 리턴 후. @After 달리 리턴 값을 알아낼 수 있다. 
   
*/





















