// SQL mapper Mybatis 적용하기. -memberDao에 적용하기.
package step33$Spring_Ioc.exam12;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MemberList {

  public static void main(String[] args) {

    try {
      ApplicationContext context =
          new ClassPathXmlApplicationContext(
              "step33$Spring_Ioc/exam12/application-context.xml");
      MemberDao memberDao = (MemberDao)context.getBean("memberDao");

      List<Member> list = memberDao.selectList();
      for (Member m : list) {
        System.out.println(m);
      }
      ((AbstractApplicationContext) context).close();
    } catch (Exception e) {
    }

  }
}
