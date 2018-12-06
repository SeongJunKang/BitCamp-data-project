//트랜잭션 다루기 - 트랜잭션 적용 전
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test15 {
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
      stmt.executeUpdate("insert into MEMBERS(MNAME,EMAIL,PWD)"+
          " values('강감찬','kang@test.com','1111');");
      stmt.executeUpdate("insert into MEMBERS(MNAME,EMAIL,PWD)"+
          " values('강감찬','kang@test.com','1111');");
      // 세 개의 insert 를 한 작업(transaction)으로 묶지 않는다면,
      // 다음과 같이 마지막 insert가 실패하더라도 이전 작업은 정상적으로 입력된다.
      
      stmt.executeUpdate("insert into MEMBERS(MNAME,EMAIL,PWD)"+
          " values('강감찬','kang@test.com','11112222222222222222');");
    } finally {
      try { stmt.close(); } catch (Exception e) { System.out.println("stmt 해제실패"); }
      try { con.close();  } catch (Exception e) { System.out.println("con 해제실패");  }
    }
  }
}
/*  
# 트랜잭션(transaction)
- 여러개의 DML SQL(Data Manipulation Language SQL; insert, update, delete)을
  한 작업 단위로 묶은 것.
- 특징.
  한 작업이라도 실패하면 이전 작업했던 모든 결과를 취소한다.
  트랜잭션에 묶인 모든 작업이 성공했을 때만 DB에 저장한다.
- 구동원리.
1) commit
  DBMS는 트랜잭션에 묶인 중간 작업결과를 임시 데이터베이스에 보관하고 있다가,
  완료 요청이 들어왔을 때 실제 테이블에 저장한다.
2) rollback
  작업 중간에 오류가 발생하여 작업 취소 요청을 받으면,
  임시 데이터베이스에 저장했던 결과를 모두 삭제한다.
 */
