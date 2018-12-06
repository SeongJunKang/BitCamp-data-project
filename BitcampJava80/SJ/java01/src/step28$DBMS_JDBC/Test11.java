//데이터 변경하기.
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test11 {
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
      int count = stmt.executeUpdate(
          "update MEMBERS set MNAME='okko' ,EMAIL='okok@test.com',PWD='1234' "
          +"where MNO='5'");
      System.out.println("변경 개수 :" + count);
    } finally {
      try { stmt.close(); } catch (Exception e) { System.out.println("stmt 해제실패"); }
      try { con.close();  } catch (Exception e) { System.out.println("con 해제실패");  }
    }
  }
}
