// SQL mapper Mybatis 적용하기. -memberDao에 적용하기.
package step30$mybatis.exam03;

import java.util.Scanner;

public class MemberAdd {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    MemberDao memberDao = new MemberDao();
    try {
      Batis mybatis = new Batis("step30$mybatis/exam03/mybatis-config.xml");
      memberDao.setSqlSessionFactory(mybatis.getSqlSessionFactory());
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
      mybatis.close();
    } catch (Exception e) {
    }
    scan.close();
  }
}
