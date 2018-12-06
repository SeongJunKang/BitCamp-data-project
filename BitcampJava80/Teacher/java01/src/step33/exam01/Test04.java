// 주제: name 속성 활용법
package step33.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam01/application-context04.xml");

    Car r1 = (Car)context.getBean("c1");
    Car r2 = (Car)context.getBean("c2");
    Car r3 = (Car)context.getBean("c4");
    Car r4 = (Car)context.getBean("c7");
    
    if (r1 != r2) System.out.println("c1 != c2");
    if (r2 != r3) System.out.println("c2 != c4");
    if (r3 != r4) System.out.println("c4 != c7");
    if (r1 != r4) System.out.println("c1 != c7");
    
    // 만약 지정한 이름의 id나 name을 찾을 수 없다면 예외 발생!
    Car r5 = (Car)context.getBean("c11");
  }

}





