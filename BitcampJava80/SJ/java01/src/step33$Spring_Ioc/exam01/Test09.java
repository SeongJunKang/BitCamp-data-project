//객체 생성 정책(scope)
package step33$Spring_Ioc.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test09 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam01/application-context09.xml");
    
    Car p1 = (Car) context.getBean("c2");
    Car p2 = (Car) context.getBean("c2");
    Car p3 = (Car) context.getBean("c2");
    
    System.out.println(p1 == p2 ? "p1==p2" : "p1!=p2");
    System.out.println(p2 == p3 ? "p2==p3" : "p3!=p2");
    //2) 기본이 singleton
    ((AbstractApplicationContext) context).close();
  }


}
