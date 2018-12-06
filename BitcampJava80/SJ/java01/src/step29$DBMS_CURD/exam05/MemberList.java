//질의하기 -- select 문 보내기
package step29$DBMS_CURD.exam05;

import java.util.List;

public class MemberList {
  public static void main(String[] args) throws Exception {
    try {
      DataSource ds = new DataSource("com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111");
      MemberDao memberDao = new MemberDao(ds);
      List<Member> list = memberDao.selectList();
      for (Member member : list) 
      System.out.printf("%d,%s,%s,%s,%s\n",
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getPassword(),
          member.getTel());
      ds.close();
    } catch (Exception e) {
      System.out.println("데이터를 가져오는데 실패했습니다");
    }
    
  }
}
