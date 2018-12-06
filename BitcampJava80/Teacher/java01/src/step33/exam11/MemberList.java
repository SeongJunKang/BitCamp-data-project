package step33.exam11;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberList {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step33/exam11/application-context.xml");
    
    MemberDao memberDao = (MemberDao)context.getBean("memberDao");
    
    List<Member> list = memberDao.selectList();
    
    for (Member m : list) {
      System.out.printf("%d,%s,%s,%s,%s\n", 
          m.getNo(),
          m.getName(),
          m.getEmail(),
          m.getPassword(),
          m.getTel());
    }
  }
}
