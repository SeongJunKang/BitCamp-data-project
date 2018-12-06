// SQL mapper Mybatis 적용하기. -memberDao에 적용하기.
package step33$Spring_Ioc.exam11;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberDelete {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    try {
      ApplicationContext context =
          new ClassPathXmlApplicationContext(
              "step33$Spring_Ioc/exam11/application-context.xml");
      MemberDao memberDao = (MemberDao)context.getBean("memberDao");
      System.out.print("지울 번호? ");
      int no = Integer.parseInt(scan.nextLine());
      memberDao.delete(no);
      ((AbstractApplicationContext) context).close();
    } catch (Exception e) {
    }
    scan.close();
  }

}
