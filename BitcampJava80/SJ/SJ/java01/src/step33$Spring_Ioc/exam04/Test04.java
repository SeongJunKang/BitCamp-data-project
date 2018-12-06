//의존객체주입과 객체생성과정
package step33$Spring_Ioc.exam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam04/application-context04.xml");
    ((AbstractApplicationContext) context).close();
  }
  
}
