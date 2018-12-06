// 주제: SQL 맵퍼인 mybatis 적용하기 - MemberDao에 적용하기 - update
package step30.exam03;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberUpdate {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(
                                  "step30/exam03/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);
    
    MemberDao memberDao = new MemberDao();
    memberDao.setSqlSessionFactory(sqlSessionFactory);
    
    Member member = new Member();
    member.setNo(11);
    member.setName("강감찬");
    member.setEmail("kang@test.com");
    member.setTel("1111-3333");
    
    memberDao.update(member);
    
    System.out.println("변경 성공!");
  }
}











