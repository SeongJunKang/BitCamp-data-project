// SQL mapper Mybatis 적용하기. -memberDao에 적용하기.
package step33$Spring_Ioc.exam12;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberUpdate {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    try {
      ApplicationContext context =
          new ClassPathXmlApplicationContext(
              "step33$Spring_Ioc/exam12/application-context.xml");
      MemberDao memberDao = (MemberDao)context.getBean("memberDao");
      Member member = new Member();
      System.out.print("바꿀 번호? ");
      member.setNo(Integer.parseInt(scan.nextLine()));
      System.out.print("이름? ");
      member.setName(scan.nextLine());
      System.out.print("이메일? ");
      member.setEmail(scan.nextLine());
      System.out.print("전화번호? ");
      member.setTel(scan.nextLine());
      memberDao.update(member);
      ((AbstractApplicationContext) context).close();
      System.out.println("업데이트 성공");
    } catch (Exception e) {
      e.printStackTrace();
    }
    scan.close();
  }
}
