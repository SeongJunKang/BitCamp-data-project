//객체 생성 정책(scope)
package step33$Spring_Ioc.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test10 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam01/application-context10.xml");
    /*3) scope 속성이 prototype일 때,
     * => getBean()을 호출하기 전까지 객체를 생성하지 않는다. 
     * => getBean()을 호출할 때 마다 매번 새 객체를 생성하여 리턴한다.
     */
    Car p1 = (Car) context.getBean("c3");
    Car p2 = (Car) context.getBean("c3");
    Car p3 = (Car) context.getBean("c3");
    //매번 새 객체를 리턴하기 때문에 p1, p2, p3는 다른 객체이다.
    System.out.println(p1 == p2 ? "p1==p2" : "p1!=p2");
    System.out.println(p2 == p3 ? "p2==p3" : "p3!=p2");
    System.out.println(p1 == p3 ? "p1==p3" : "p1!=p3");
    ((AbstractApplicationContext) context).close();
  }


}
