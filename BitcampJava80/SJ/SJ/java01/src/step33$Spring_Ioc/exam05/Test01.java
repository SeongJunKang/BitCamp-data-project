// 의존 배열 객체 주입
package step33$Spring_Ioc.exam05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam05/application-context.xml");
    
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("c2"));
    System.out.println(context.getBean("c3"));
    System.out.println(context.getBean("c4"));
    
    ((AbstractApplicationContext) context).close();
  }
  
}
