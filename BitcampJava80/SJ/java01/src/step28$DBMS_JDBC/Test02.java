//예외처리와 연결해제1 - 연결해제를 자동으로 하기 전. 
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class Test02 {

    public static void main(String[] args) {
      try {
        DriverManager.deregisterDriver(new Driver());
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java80db?user=java80&password=1111");
        System.out.println("연결성공 !");
        //다음문장은 0나누기 예외를 발생.
        System.out.printf("5/0 = %d\n",5/0);
        System.out.println("맑은날씨입니다.");
        con.close();
      } catch (Exception e) {
        System.out.println("에러발생 !");
        e.printStackTrace();
      }
    } 
}

/*
*/

















