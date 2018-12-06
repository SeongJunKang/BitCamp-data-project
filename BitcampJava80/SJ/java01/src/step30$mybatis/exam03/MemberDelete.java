// SQL mapper Mybatis 적용하기. -memberDao에 적용하기.
package step30$mybatis.exam03;

import java.util.Scanner;

public class MemberDelete {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    MemberDao memberDao = new MemberDao();
    try {
      Batis mybatis = new Batis("step30$mybatis/exam03/mybatis-config.xml");
      memberDao.setSqlSessionFactory(mybatis.getSqlSessionFactory());
      System.out.print("지울 번호? ");
      int no = Integer.parseInt(scan.nextLine());
      memberDao.delete(no);
      mybatis.close();
    } catch (Exception e) {
    }
    scan.close();
  }

}
