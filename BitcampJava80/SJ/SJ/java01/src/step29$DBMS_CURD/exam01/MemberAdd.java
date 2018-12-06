//데이터 추가하기.
package step29$DBMS_CURD.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MemberAdd {
  public static void main(String[] args) throws Exception {
    Connection con = null;
    Statement stmt = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111");
      stmt = con.createStatement();
      int count = stmt.executeUpdate("insert into MEMBERS(MNAME,EMAIL,PWD)"+
          " values('강감찬','kang@test.com','1111');");
      System.out.println("입력 개수 :" + count);
    } finally {
      try { stmt.close(); } catch (Exception e) { System.out.println("stmt 해제실패"); }
      try { con.close();  } catch (Exception e) { System.out.println("con 해제실패");  }
    }
  }
}
