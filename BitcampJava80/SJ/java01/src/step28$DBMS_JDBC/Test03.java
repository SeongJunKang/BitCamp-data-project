//예외처리와 연결해제2 - 연결해제를 자동으로 한 후.
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class Test03 {

  public static void main(String[] args) {
    Connection con = null;
    try {
      try {
      DriverManager.deregisterDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java80db?user=java80&password=1111");
      } catch (Exception e) {}
      
      System.out.println("연결성공 !");
      System.out.printf("5/0 = %d\n", 5 / 0);
      System.out.println("맑은날씨입니다."); // < 실행안됩
    } finally {
      // try블록을 벗어나기 전에 무조건 자동으로 실행.
      // 1)try 블록에서 예외가 발생해 상위 호출자에게 보고 하더라도
      // 2) try 블록 중간에서 메서드를 탈출(return) 하더라도
      // 무조건 finally블록이 실행된다.
      try {
        con.close();
      } catch (Exception e) {
      }
      // close() : 닫다가 예외가 발생할 수 있다.
      // close() 에 대한 예외를 사용자에게 알릴 필요는 없다.
      // 따라서 close()에 대해 try...catch로 처리하라.
      // 물론 닫다가 발생된 예외에 대해서는 특별히 할 일이 없다.
      // 그냥 JVM이 오류 문구를 내 뱉는 것을 막기 위함.
    }
  }
}

/*
*/
