//데이터 추가하기.
package step29$DBMS_CURD.exam04;

public class MemberAdd {
  public static void main(String[] args) throws Exception {
    try {
      Member member = new Member("세종대왕","sae@test.com","1111","1111-1111");
      MemberDao memberDao = new MemberDao("com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111");
      System.out.println("입력 갯수 :"+memberDao.insert(member));
      memberDao.destroy();
    } catch(Exception e) {
      System.out.println("insert실패");
    }
  }
}
