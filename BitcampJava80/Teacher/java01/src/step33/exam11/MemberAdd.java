package step33.exam11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberAdd {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step33/exam11/application-context.xml");
    
    MemberDao memberDao = (MemberDao)context.getBean("memberDao");
    
    Member member = new Member();
    member.setName("세종대왕");
    member.setEmail("sae@test.com");
    member.setPassword("1111");
    member.setTel("1111-1111");
    
    memberDao.insert(member);
    System.out.println("입력 성공!");
  }
}
