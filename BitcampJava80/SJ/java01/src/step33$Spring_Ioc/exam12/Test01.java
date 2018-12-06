//@Component 애노테이션을 이용한 객체 생성하기.
package step33$Spring_Ioc.exam12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam12/application-context.xml");
    printAllObjects(context);
    System.out.println(context.getBean("memberDao"));
    ((AbstractApplicationContext) context).close();
  }
  
  private static void printAllObjects(ApplicationContext context) {
    String[] names = context.getBeanDefinitionNames();
    System.out.println("====================================");
    for (String name : names) {
      System.out.println(context.getBean(name).getClass().getName());
    }
    System.out.println("====================================");
  }
  
}
