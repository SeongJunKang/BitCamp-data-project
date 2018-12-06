// 프로퍼티 호출하기.
package step33$Spring_Ioc.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("step33$Spring_Ioc/exam03/application-context.xml");
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("c2"));
    ((AbstractApplicationContext) context).close();
  }
  
}
