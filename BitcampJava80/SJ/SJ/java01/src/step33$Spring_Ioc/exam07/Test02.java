// Factory 를 이용하여 객체를 생성
package step33$Spring_Ioc.exam07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam07/application-context02.xml");
    
    System.out.println(context.getBean("c1"));
    
    ((AbstractApplicationContext) context).close();
  }
  
}
