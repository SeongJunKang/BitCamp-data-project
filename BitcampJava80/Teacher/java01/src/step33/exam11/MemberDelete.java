package step33.exam11;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberDelete {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step33/exam11/application-context.xml");
    
    MemberDao memberDao = (MemberDao)context.getBean("memberDao");
    
    memberDao.delete(1);
    
    System.out.println("삭제 성공!");
  }
}











