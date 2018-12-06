package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.domain.Project;

@Component
public class ProjectDao {

//  public void insert(Project project) throws Exception {
//    PreparedStatement stmt = null;
//    try {
//      Connection con = dataSource.getConnection();
//      stmt = con.prepareStatement("insert into PROJECTS(TITLE,SDT,EDT,DESCT) values(?,?,?,?)");
//      stmt.setString(1, project.getTitle());
//      stmt.setDate(2, project.getStartDate());
//      stmt.setDate(3, project.getEndDate());
//      stmt.setString(4, project.getDescription());
//      stmt.executeUpdate();
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//      }
//    }
//  }
//
//  public List<Project> selectList() throws Exception {
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
//    ArrayList<Project> list = new ArrayList<>();
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("select * from PROJECTS");
//      rs = stmt.executeQuery();
//      Project project;
//      while (rs.next()) {
//        project = new Project();
//        project.setNo(rs.getInt("PNO"));
//        project.setTitle(rs.getString("TITLE"));
//        project.setStartDate(rs.getDate("SDT"));
//        project.setEndDate(rs.getDate("EDT"));
//        project.setDescription(rs.getString("DESCT"));
//        project.setState(rs.getInt("STAT"));
//        list.add(project);
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
//  public Project selectOne(int no) throws Exception {
//
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("select * from PROJECTS where PNO=?");
//      stmt.setInt(1, no);
//      rs = stmt.executeQuery();
//      Project project = null;
//      while (rs.next()) {
//        project = new Project();
//        project.setNo(rs.getInt("PNO"));
//        project.setTitle(rs.getString("TITLE"));
//        project.setStartDate(rs.getDate("SDT"));
//        project.setEndDate(rs.getDate("EDT"));
//        project.setDescription(rs.getString("DESCT"));
//        project.setState(rs.getInt("STAT"));
//      }
//      return project;
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
//  public int update(Project project) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("update PROJECTS set TITLE=? ," 
//    + " SDT=? , EDT=?, DESCT=? where PNO=?");
//      stmt.setString(1, project.getTitle());
//      stmt.setDate(2, project.getStartDate());
//      stmt.setDate(3, project.getEndDate());
//      stmt.setString(4, project.getDescription());
//      stmt.setInt(5, project.getNo());
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
//      stmt = con.prepareStatement("delete from PROJECTS where PNO =?");
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
}
