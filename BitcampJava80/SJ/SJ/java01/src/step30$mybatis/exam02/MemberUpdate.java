// SQL mapper Mybatis 적용하기. -memberDao에 적용하기.
package step30$mybatis.exam02;

import java.util.Scanner;

public class MemberUpdate {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    MemberDao memberDao = new MemberDao();
    try {
      Batis mybatis = new Batis("step30/exam02/mybatis-config.xml");
      memberDao.setSqlSessionFactory(mybatis.getSqlSessionFactory());
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
      mybatis.close();
      System.out.println("업데이트 성공");
    } catch (Exception e) {
      e.printStackTrace();
    }
    scan.close();
  }
}
