//데이터 삭제하기.
package step29$DBMS_CURD.exam04;

import java.util.Scanner;

public class MemberDelete {
  static Scanner keyscan = new Scanner(System.in);
  public static void main(String[] args) throws Exception {
    try {
      System.out.print("삭제할 데이터 테이블 번호? ");
      int no = keyscan.nextInt();
      MemberDao memberDao = new MemberDao("com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111");
      System.out.println("삭제 갯수 : "+memberDao.delete(no));
      memberDao.destroy();
    } catch(Exception e) {
    }
  }
}
