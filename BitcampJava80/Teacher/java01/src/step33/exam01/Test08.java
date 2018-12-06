// 주제: 객체 생성 정책(scope)
package step33.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam01/application-context08.xml");

    //1) scope 속성을 지정하지 않았을 때,
    //=> 객체가 한 개만 생성된다.
    Car p1 = (Car) context.getBean("c1");
    Car p2 = (Car) context.getBean("c1");
    Car p3 = (Car) context.getBean("c1");
    
    if (p1 == p2) System.out.println("p1 == p2");
    if (p2 == p3) System.out.println("p2 == p3");
  }
}













