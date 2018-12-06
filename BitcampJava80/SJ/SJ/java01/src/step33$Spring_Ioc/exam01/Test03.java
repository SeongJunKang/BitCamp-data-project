// 스프링 IoC 컨테이너 (빈 컨테이너) 사용 전
package step33$Spring_Ioc.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("step33$Spring_Ioc/exam01/application-context03.xml");
    // <bean name="c1" class="stepp33.exam01.Car">
    Car r1 = (Car)context.getBean("c1");
    System.out.println(r1);
    ((AbstractApplicationContext) context).close();
  }

}
