// 주제: name 속성
package step33.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam01/application-context03.xml");

    //<bean name="c1" class="step33.exam01.Car"/>
    Car r1 = (Car)context.getBean("c1");
    System.out.println(r1);
  }

}





