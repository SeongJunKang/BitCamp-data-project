// 주제: 트랜잭션 다루기 - 트랜잭션 적용 후
package step28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test16 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111");
      
      // 트랜잭션을 활성화시킨다.
      // => commit이라는 명령을 내릴 때까지 자동으로 커밋하지 말라!
      con.setAutoCommit(false); // 기본이 true이다.
      
      stmt = con.createStatement();

      stmt.executeUpdate("insert into MEMBERS(MNAME,EMAIL,PWD)"
          + " values('강감찬1','kang@test.com','1111');");
      stmt.executeUpdate("insert into MEMBERS(MNAME,EMAIL,PWD)"
          + " values('강감찬2','kang@test.com','1111');");
      
      
      // 다음 insert문을 실행할 때 오류가 발생한다면 이전 작업 결과는 취소된다.
      stmt.executeUpdate("insert into MEMBERS(MNAME,EMAIL,PWD)"
          + " values('강감찬3','kang@test.com','1234567890');");
    
      // 모든 작업이 정상적으로 수행했다면, 
      // DBMS에 임시 데이터베이스에 있는 작업 결과를 테이블에 넣으라고 요청한다.
      con.commit();
      
    } catch (Exception e) {
      // 오류가 발생했다면, 
      // DBMS에 지금까지 수행한 작업 결과를 모두 취소할 것을 요청한다.
      con.rollback();
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}

/*
# 트랜잭션 명령
1) Connection.commit()
   => DBMS에게 지금까지 수행한 작업 결과를 테이블에 반영하라고 명령한다.
   => DBMS는 임시 데이터베이스에 저장된 작업 결과를 실제 테이블에 반영한다.
2) Connection.rollback()
   => DBMS에게 지금까지 수행한 작업 결과를 모두 취소할 것을 명령한다.
   => DBMS는 임시 데이터베이스에 저장된 작업 결과를 모두 삭제한다. 

# 중요!
=> 트랜잭션은 Connection 단위로 관리를 한다.
=> 한 커넥션을 여러 스레드가 사용하고 있을 때, 
   그 중 한 스레드가 자신이 작업한 결과를 서버에 반영하기 위해서
   커밋하는 순간 다른 스레드의 작업 결과에 상관없이
   이 커넥션으로 생성된 모든 Statement(PreparedStatement) 작업 결과가
   커밋되는 문제가 있다.
=> 그래서 DB 커넥션을 공유하지 않는 것이다.
=> 그렇다고 각 스레드마다 DB 커넷션을 생성해 쓴다면 너무 속도가 느리고
   메모리가 낭비된다.
=> 이를 해결하기 위해 나온 방법이 DB 커넥션 풀(pooling 기법)이다.   
    
 */









