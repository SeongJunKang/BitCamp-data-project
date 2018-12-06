package step33.exam12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberUpdate {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step33/exam12/application-context.xml");
    
    MemberDao memberDao = (MemberDao)context.getBean("memberDao");
    
    Member member = new Member();
    member.setNo(5);
    member.setName("강감찬");
    member.setEmail("kang@test.com");
    member.setTel("1111-3333");
    
    memberDao.update(member);
    
    System.out.println("변경 성공!");
  }
}











