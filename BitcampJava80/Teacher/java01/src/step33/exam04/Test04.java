// 주제: 의존 객체 주입과 객체 생성 과정 확인
package step33.exam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam04/application-context04.xml");
  }

}





