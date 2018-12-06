// 주제: 생성자의 넘겨 주는 값의 순서 
package step33.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam02/application-context02.xml");
    
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("c2"));
    System.out.println(context.getBean("c3"));
    System.out.println(context.getBean("c5"));
    System.out.println(context.getBean("c6"));
  }

}





