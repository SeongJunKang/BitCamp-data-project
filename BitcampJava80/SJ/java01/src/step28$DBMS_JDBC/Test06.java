//다양한 예외 확인.
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Test06 {

  public static void main(String[] args) throws SQLException {
    
    DriverManager.deregisterDriver(new Driver());
    try(
        Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java80db", 
        "java80",
        "1111"
        ) ) {        
      
      System.out.println("연결성공 !");
    } 
  }
}

/*
 * 
 * # 오타 등의 이유로 JDBC URL 형식이 잘못되었을때
 *  ->No suitable driver found for
 *  
 * # 서버가 존재하지 않거나 해당 IP를 가진 컴퓨터가 실행중이지 않을떄
 * # port번호가 다를 때
 *  -> Communications link failure
 *  -> The driver has not received any packets from the server.
 * 
 * # 존재하지 않는 DBMS를 가리킬 떄, 
 * ->Access denied for user 'java80'@'localhost' to database 'java81db'
 * # 아이디나 비밀번호가 틀릴떄.
 * ->Access denied for user 'java801'@'localhost' (using password: YES)
 *
 * # 
 * -> too many connection
 * 
*/
