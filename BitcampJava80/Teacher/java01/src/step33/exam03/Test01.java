// 주제: 프로퍼티 호출하기 
package step33.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam03/application-context.xml");

    System.out.println(context.getBean("c1"));
  }

}





