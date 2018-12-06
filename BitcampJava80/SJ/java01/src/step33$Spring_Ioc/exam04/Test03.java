//의존객체주입
package step33$Spring_Ioc.exam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            "step33$Spring_Ioc/exam04/application-context03.xml");
    Engine e = (Engine)context.getBean("e1");
    Car c1 =(Car)context.getBean("c1");
    Car c2 =(Car)context.getBean("c2");
    Car c3 =(Car)context.getBean("c3");
    Car c4 =(Car)context.getBean("c4");
    /*
     * c1과 c2에 주입된 Engine은 같은 객체이다.
     * 빈 컨테이너는 기본으로 객체를 한 개만 생성하여 공유한다
     */
    System.out.println(e == c1.engine ? "e==c1":"e!=c1");
    System.out.println(e == c2.engine ? "e==c2":"e!=c2");
    System.out.println(c1.engine  == c2.engine ?
        "c1.engine ==c2.engine ":"c1.engine != c2.engine ");
    System.out.println(c2.engine  == c3.engine ?
        "c2.engine ==c3.engine ":"c2.engine != c3.engine ");
    System.out.println(c3.engine  == c4.engine ?
        "c3.engine ==c4.engine ":"c3.engine != c4.engine ");
    ((AbstractApplicationContext) context).close();
  }
  
}
