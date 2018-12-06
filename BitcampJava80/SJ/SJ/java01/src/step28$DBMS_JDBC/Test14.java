//Statement 사용시 문제점 해결 -preparedStatement 사용
package step28$DBMS_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test14 {
  public static void main(String[] args) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111");
      String str = "1 or 1=1";
      //1) 미리 sql문을 준비한다.
      // 단 값이 입력되어야 할 부분은 IN-PARAMETER(?)로 표시한다.
      stmt = con.prepareStatement("select * from MEMBERS where MNO=?");
      
      //2)값을 따로 입력한다.
      // 숫자값을 입력할 때 setString()을 사용할 수 있다.
      // 원래 setInt 사용해야함.
      // PreparedStatement는 지정된 위치에 들어갈 수 있는 값만 넣는다.
      // 해커가 임의의 SQL 문을 삽입할 수 없다.
      stmt.setString(1, str);
      //3) 질의 수행
      rs = stmt.executeQuery();
      
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

/* PreparedStatement vs Statement
 * 
 * 1. 임의의 SQL 코드를 삽입할 수 없다. ==> 보안이 좋다.
 * 2. SQL문과 값이 분리되어있다. ==> 코드 작성 및 가독성이 좋다.
 * 3. 바이너리 데이터를 저장할 수 있다. ==> Statement에서는 특별한 인코딩을 해야한다.
 * 
 * #Base64 (바이너리 --> 문자열) 
 * - 바이너리 데이터를 영어 대/소문자, 숫자, '+', '/' 등을 이용하여 문자열로 변환할 때 사용.
 * - 주로 바이너리 데이터를 문자열로 저장할 때 사용한다.
 * - 저장된 데이터를 사용할 때 문자열을 원래의 바이너리 값으로 복원(디코딩)한 후 사용.
 * 
 */

