//
package step33$Spring_Ioc.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("step33$Spring_Ioc/exam01/application-context06.xml");
    System.out.println("빈의 개수 : " +context.getBeanDefinitionCount());
    System.out.println("----------------------------------------------");
    System.out.println("빈의 이름들 : ");
    String[] names = context.getBeanDefinitionNames();
    String[] aliases;
    for (String name : names) {
      System.out.print(name);
      System.out.print(" // 빈의 다른 이름들 : ");
      aliases = context.getAliases(name);
      for (String alias : aliases) {
        System.out.print(alias+",");
      }
      System.out.println();
    }
    System.out.println("-------------------------------------------------");
    
    Car obj1 = (Car) context.getBean("step33$Spring_Ioc.exam01.Car#0");
    Car obj2 = (Car) context.getBean("step33$Spring_Ioc.exam01.Car");
    System.out.println(obj1 == obj2 ? "같다" : "다르다");
    System.out.println(obj1);
    System.out.println(obj2);
    ((AbstractApplicationContext) context).close();
  }


}
