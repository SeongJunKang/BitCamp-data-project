//예외처리와 연결해제3 - try (자원){} 문법 사용하여 자동으로 자원해제하기.
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class Test04 {

  public static void main(String[] args) throws Exception{
    
    DriverManager.deregisterDriver(new Driver());
    try(
        // 여기에 선언한 모든 자원은 try 블록을 벗어나기 전에 자동으로 해제된다.
        // 따라서 finally  블록에 close() 시킬 필요가 없다.
        // 단 자동으로 해제시키는 자원은 java.lang.AutoCloseAble 구현체여야한다.
        Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java80db",   //JDBC URL
        "java80",           // DBMS 사용자 아이디
        "1111"              // DBMS 사용자 비밀번호.
        ) ) {        
      
      System.out.println("연결성공 !");
      System.out.printf("5/0 = %d\n", 5 / 0);
      System.out.println("맑은날씨입니다."); // < 실행안됩
    } 
  }
}

/*
*/
