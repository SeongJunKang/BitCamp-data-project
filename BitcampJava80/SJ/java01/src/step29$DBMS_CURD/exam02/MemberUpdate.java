//데이터 변경하기.
package step29$DBMS_CURD.exam02;

import java.util.Scanner;

public class MemberUpdate {
  static Scanner keyscan = new Scanner(System.in);
  public static void main(String[] args) throws Exception {
    try {
      System.out.print("변경할 번호? ");
      int no = keyscan.nextInt();
      Member member = new Member("update","update@test.com","update","1010-1100");
      member.setNo(no);
      MemberDao memberDao = new MemberDao();
      System.out.println("변경 갯수 : "+memberDao.update( member));
    } catch(Exception e) {
    }
  }
}
