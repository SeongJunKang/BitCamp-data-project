//@Autowired Annotation을 이용한 의존 객체 주입 
// @Required 등록
package step33$Spring_Ioc.exam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam09/application-context03.xml");
    printAllObjects(context);
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("e1"));
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
