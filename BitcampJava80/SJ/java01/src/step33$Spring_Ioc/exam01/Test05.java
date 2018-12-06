// id와 name 의 내부적인 동작원리
package step33$Spring_Ioc.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("step33$Spring_Ioc/exam01/application-context04.xml");
    
    //1) 생성된 빈의 개수 알아내기
    System.out.println("빈의 개수 : " +context.getBeanDefinitionCount());
    System.out.println("----------------------------------------------");
    //2) 빈의 이름(id 속성에 지정한 이름)을 알아내기
    // => id 속성이 없는 빈은 name 속성의 가장 첫 번째 이름을 사용한다.
    // => id 속성이 있다면 그 값을 빈의 공식적인 이름을 사용한다.
    // => 나머지 이름은? 별명으로 간주한다.
    System.out.println("빈의 이름들 : ");
    String[] names = context.getBeanDefinitionNames();
    String[] aliases;
    for (String name : names) {
      System.out.print(name);
      System.out.print(" 빈의 다른 이름들 : ");
      // 3) 빈의 나머지 이름들 알아내기

      aliases = context.getAliases(name);
      for (String alias : aliases) {
        System.out.print(alias+",");
      }
      System.out.println();
    }
    // 4) getAliases => 나머지 이름을 리턴하는 메서드
    aliases = context.getAliases("c9");
    for (String alias : aliases) {
      System.out.print(alias+",");
    }
    System.out.println("----------------------------------------------");
    ((AbstractApplicationContext) context).close();
  }
  /*
   * 결론,
   * => 빈 컨테이너에서 객체를 꺼낼 때, id든 name이든 구분없이
   * 이름을 지정하면된다.
   */

}
