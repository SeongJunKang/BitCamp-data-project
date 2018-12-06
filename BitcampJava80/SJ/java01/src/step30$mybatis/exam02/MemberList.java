// SQL mapper Mybatis 적용하기. -memberDao에 적용하기.
package step30$mybatis.exam02;

import java.util.List;


public class MemberList {

  public static void main(String[] args) {

    MemberDao memberDao = new MemberDao();
    try {
      Batis mybatis = new Batis("step30$mybatis/exam02/mybatis-config.xml");
      memberDao.setSqlSessionFactory(mybatis.getSqlSessionFactory());

      List<Member> list = memberDao.selectList();
      for (Member m : list) {
        System.out.println(m);
      }
    } catch (Exception e) {
    }

  }
}
