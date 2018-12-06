package step29$DBMS_CURD.exam05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DataSource {
  ArrayList<Connection> connectionPool = new ArrayList<>();
  
  String jdbcDriver;
  String jdbcUrl;
  String userName;
  String password;
  public DataSource(String jdbcDriver, String jdbcUrl,
      String userName, String password) {
    this.jdbcDriver = jdbcDriver;
    this.jdbcUrl = jdbcUrl;
    this.userName = userName;
    this.password = password;
  }
  
  public Connection getConnection() throws Exception {
    if (connectionPool.size() > 0) {
      return connectionPool.remove(0);
    }
    return DriverManager.getConnection(jdbcUrl,userName,password);
  }
  public void returnConnection(Connection con) {
    connectionPool.add(con);
  }
  
  public void close() {
    for (Connection con : connectionPool) {
      try {
        con.close();
      } catch (Exception e) {}
    }
  }
}
