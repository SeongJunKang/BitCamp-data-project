//의존객체주입
package step33$Spring_Ioc.exam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam04/application-context02.xml");
    
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("c2"));
    ((AbstractApplicationContext) context).close();
  }
  
}
