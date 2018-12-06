package bitcamp.pms.dao;

import bitcamp.pms.annotation.Component;

@Component
public class TaskDao {
//
//  public void insert(Task task) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("insert into TASKS(TITLE,SDT,EDT,WKE,CONTS) values(?,?,?,?,?)");
//      stmt.setString(1, task.getTitle());
//      stmt.setDate(2, task.getStartDate());
//      stmt.setDate(3, task.getEndDate());
//      stmt.setString(4, task.getWorkerEmail());
//      stmt.setString(5, task.getContent());
//      stmt.executeUpdate();
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//      }
//      dataSource.returnConnection(con);
//    }
//  }
//
//  public List<Task> selectList() throws Exception {
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
//    ArrayList<Task> list = new ArrayList<>();
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("select * from TASKS");
//      rs = stmt.executeQuery();
//      Task task;
//      while (rs.next()) {
//        task = new Task();
//        task.setNo(rs.getInt("TNO"));
//        task.setTitle(rs.getString("TITLE"));
//        task.setStartDate(rs.getDate("SDT"));
//        task.setEndDate(rs.getDate("EDT"));
//        task.setWorkerEmail(rs.getString("WKE"));
//        task.setContent(rs.getString("CONTS"));
//        task.setState(rs.getInt("STAT"));
//        list.add(task);
//      }
//      return list;
//    } finally {
//      try {
//        rs.close();
//      } catch (Exception e) {
//      }
//      try {
//        stmt.close();
//      } catch (Exception e) {
//      }
//      dataSource.returnConnection(con);
//    }
//  }
//
//  public Task selectOne(int no) throws Exception {
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("select * from TASKS where TNO=?");
//      stmt.setInt(1, no);
//      rs = stmt.executeQuery();
//      Task task = null;
//      while (rs.next()) {
//        task = new Task();
//        task.setNo(rs.getInt("TNO"));
//        task.setTitle(rs.getString("TITLE"));
//        task.setStartDate(rs.getDate("SDT"));
//        task.setEndDate(rs.getDate("EDT"));
//        task.setWorkerEmail(rs.getString("WKE"));
//        task.setContent(rs.getString("CONTS"));
//        task.setState(rs.getInt("STAT"));
//      }
//      return task;
//
//    } finally {
//      try {
//        rs.close();
//      } catch (Exception e) {
//      }
//      try {
//        stmt.close();
//      } catch (Exception e) {
//      }
//      dataSource.returnConnection(con);
//    }
//  }
//
//  public int update(Task task) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("update TASKS set TITLE=? ," 
//    + " SDT=? , EDT=?, CONTS=?, WKE=? where TNO=?");
//      stmt.setString(1, task.getTitle());
//      stmt.setDate(2, task.getStartDate());
//      stmt.setDate(3, task.getEndDate());
//      stmt.setString(4, task.getContent());
//      stmt.setString(5, task.getWorkerEmail());
//      stmt.setInt(6, task.getNo());
//
//      return stmt.executeUpdate();
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//      }
//      dataSource.returnConnection(con);
//    }
//  }
//
//  public int delete(int no) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("delete from TASKS where TNO =?");
//      stmt.setInt(1, no);
//      return stmt.executeUpdate();
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//      }
//      dataSource.returnConnection(con);
//    }
//  }
//
}
