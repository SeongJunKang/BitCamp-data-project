//데이터 추가하기.
package step29$DBMS_CURD.exam03;

public class MemberAdd {
  public static void main(String[] args) throws Exception {
    try {
      Member member = new Member("세종대왕","sae@test.com","1111","1111-1111");
      MemberDao memberDao = new MemberDao();
      System.out.println(memberDao.insert(member));
    } catch(Exception e) {
      System.out.println("insert실패");
    }
  }
}
