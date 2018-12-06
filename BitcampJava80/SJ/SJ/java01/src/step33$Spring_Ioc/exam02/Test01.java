// 생성자 호출하기.
package step33$Spring_Ioc.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("step33$Spring_Ioc/exam02/application-context.xml");
    ((AbstractApplicationContext) context).close();
  }

}
