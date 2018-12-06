// 주제: 빈의 이름을 지정하지 않은 객체를 여러 개 만들 때?
package step33.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam01/application-context07.xml");

    System.out.printf("빈의 개수: %d\n", context.getBeanDefinitionCount());
    System.out.println("-----------------------");
    
    System.out.println("빈의 이름들: ");
    String[] names = context.getBeanDefinitionNames();
    String[] aliases;
    for (String name : names) {
      System.out.print(name + ",");

      System.out.print("  빈의 기타 이름들: ");
      aliases = context.getAliases(name);
      for (String alias : aliases) {
        System.out.print(alias + ",");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("-----------------------");
  
    Car obj1 = (Car) context.getBean("step33.exam01.Car#0");
    Car obj2 = (Car) context.getBean("step33.exam01.Car");
  }
}













