//Statement 사용시 문제점 
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test13 {
  public static void main(String[] args) throws Exception {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111");
      stmt = con.createStatement();
      //1 .사용자가 값을 입력할 때 SQL 실행에 영향을 미치는 코드는 삽입할 경우,
      //2 .Statement에서는 SQL문을 서버에 보낼 때 문자열로 표현한다.
      // 즉 사용자가 입력한 값을 SQL문을 만들 때 붙인다.
      // 사용자가 입력 값에 넣은 SQL코드도 함께 삽입될 수 있다.
      //3 .무방비로 데이터가 노출되거나 변경 될 수 있다.
      String str ="1 or MNO =2";
      rs = stmt.executeQuery("select * from MEMBERS where MNO="+str);
      while(rs.next()) {
        System.out.println(rs.getInt("MNO")+","+rs.getString("MNAME")+
            ","+rs.getString("EMAIL")+","+rs.getString("PWD"));
      }
    } finally {
      try { stmt.close(); } catch (Exception e) { System.out.println("stmt 해제실패"); }
      try { con.close();  } catch (Exception e) { System.out.println("con 해제실패");  }
    }
  }
}
