//데이터 삭제하기.
package step29$DBMS_CURD.exam02;

import java.util.Scanner;

public class MemberDelete {
  static Scanner keyscan = new Scanner(System.in);
  public static void main(String[] args) throws Exception {
    try {
      System.out.print("삭제할 번호? ");
      int no = keyscan.nextInt();
      MemberDao memberDao = new MemberDao();
      System.out.println("삭제 갯수 : "+memberDao.delete(no));
    } catch(Exception e) {
    }
  }
}
