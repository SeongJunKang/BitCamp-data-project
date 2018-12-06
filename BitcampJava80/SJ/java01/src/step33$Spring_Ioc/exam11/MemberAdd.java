// SQL mapper Mybatis 적용하기. -memberDao에 적용하기.
package step33$Spring_Ioc.exam11;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberAdd {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    try {
      ApplicationContext context =
          new ClassPathXmlApplicationContext(
              "step33$Spring_Ioc/exam11/application-context.xml");
      MemberDao memberDao = (MemberDao)context.getBean("memberDao");
      Member member = new Member();
      System.out.print("이름? ");
      member.setName(scan.nextLine());
      System.out.print("이메일? ");
      member.setEmail(scan.nextLine());
      System.out.print("암호? ");
      member.setPassword(scan.nextLine());
      System.out.print("전화번호? ");
      member.setTel(scan.nextLine());
      memberDao.insert(member);
      ((AbstractApplicationContext) context).close();
    } catch (Exception e) {
    }
    scan.close();
  }
}
