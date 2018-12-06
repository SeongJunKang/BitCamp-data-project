//다양한 예외 확인.
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test08 {
  public static void main(String[] args) throws Exception {
    // 방법 1 : 직접 java.sql.Driver 구현체의 인스턴ㅁ스를 생성하여 등록하기
    // DriverManager.deregisterDriver(new Driver());
    // 방법 2 : java.sql.Driver 클래스를 로딩하기
    Class.forName("com.mysql.jdbc.Driver");
    // 방법 3 : java.sql.Driver 구현체의 인스턴스 만들기
    // Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con = null;
    Statement stmt = null;
    try {
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111");
      System.out.println("연결성공 !");
      stmt = con.createStatement();
      System.out.println("질의 객체 준비 완료 !");
    } finally {
      // 자원해제는 역순으로.
      try {
        stmt.close();
      } catch (Exception e) {
      }
      try {
        con.close();
      } catch (Exception e) {
      }
    }
  }
}
