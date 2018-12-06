//예외처리와 연결해제4 -프로그램에서 예외처리하기
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Test05 {

  public static void main(String[] args) throws SQLException {
    
    DriverManager.deregisterDriver(new Driver());
    try(
        Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java80db", 
        "java80",
        "1111"
        ) ) {        
      
      System.out.println("연결성공 !");
      System.out.printf("5/0 = %d\n", 5 / 0);
      System.out.println("맑은날씨입니다."); // < 실행안됩
    } catch(ArithmeticException e) {
      System.out.println("잘못 나눴어");
    }
  }
}

/*
*/
