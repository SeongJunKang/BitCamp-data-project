package bitcamp.pms.dao;

import java.util.List;

import bitcamp.pms.domain.Project;

public interface ProjectDao {
  List<Project> selectList();
  int insert(Project project);
  Project selectOne(int no);
  int update(Project project);
  int delete(int no);
  
/*

  public int delete(int no) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dataSource.getConnection();
      stmt = con.prepareStatement("delete from PROJECTS where PNO=?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dataSource.returnConnection(con);
    }
  }
*/
}
