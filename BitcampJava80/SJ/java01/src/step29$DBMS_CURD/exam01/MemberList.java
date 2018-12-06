//질의하기 -- select 문 보내기
package step29$DBMS_CURD.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberList {
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
      System.out.println("연결성공 !");
      stmt = con.createStatement();
      
      System.out.println("질의 객체 준비 완료 !");
      
      // 서버에 sql 문 보내기
      // select 결과를 리턴하는 것이 아니다.
      // 서버로부터 결과를 가져올 때 사용할 도구를 리턴.
      rs = stmt.executeQuery("select * from MEMBERS");
      // 서버에서 한개의 결과를 가져오기.
      while ( rs.next() )   //결과를 가져오면 true .
      System.out.printf("%d,%s,%s,%s\n",
          rs.getInt("MNO"),
          rs.getString("MNAME"),
          rs.getString("EMAIL"),
          rs.getShort("PWD"));
    } finally {
      try { rs.close();   } catch (Exception e) { System.out.println("rs 해제실패");   }
      try { stmt.close(); } catch (Exception e) { System.out.println("stmt 해제실패"); }
      try { con.close();  } catch (Exception e) { System.out.println("con 해제실패");  }
    }
  }
}
