// 스프링 IoC 컨테이너 (빈 컨테이너) 사용 전
package step33$Spring_Ioc.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  public static void main(String[] args) {
    //2. Car 객체 준비
    ApplicationContext context =
        new ClassPathXmlApplicationContext("step33$Spring_Ioc/exam01/application-context.xml");
    //2. Car 객체 꺼내기
    Car r1 = (Car)context.getBean("c1");
    Car r2 = (Car)context.getBean("c1");
    if (r1 ==r2) {
      System.out.println("기본으로 인스턴스는 한개만 생성");
    }
    System.out.println(r1);
    ((AbstractApplicationContext) context).close();
  }

}
