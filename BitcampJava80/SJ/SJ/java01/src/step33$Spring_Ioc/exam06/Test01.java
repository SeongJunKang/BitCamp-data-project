// 의존 배열 객체 주입
package step33$Spring_Ioc.exam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam06/application-context.xml");
    
    System.out.println(context.getBean("c1"));
    
    ((AbstractApplicationContext) context).close();
  }
  
}
