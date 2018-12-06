// name 속성 활용법
package step33$Spring_Ioc.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("step33$Spring_Ioc/exam01/application-context04.xml");
    Car r1 = (Car)context.getBean("c1");
    Car r2 = (Car)context.getBean("c2");
    Car r4 = (Car)context.getBean("c4");
    Car r7 = (Car)context.getBean("c7");
    //  각 name 마다 다른 인스턴스를 가진다.
    System.out.println(r1);
    System.out.println(r2);
    System.out.println(r4);
    System.out.println(r7);
    ((AbstractApplicationContext) context).close();
  }

}
