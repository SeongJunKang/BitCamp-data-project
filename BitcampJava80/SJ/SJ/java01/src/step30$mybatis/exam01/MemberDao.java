package step30$mybatis.exam01;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {

  SqlSessionFactory sqlSessionFactory;

  public MemberDao() {
  }
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Member> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("MemberDao.selectList");
    } finally {
      sqlSession.close();
    }
  }
  
//  public int insert(Member member) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("insert into MEMBERS(Mer) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("insert into MEMBERS(MNAME,EMAIL,PWD,TEL) values(?,?,?,?)");
//      stmt.setString(1, member.getName());
//      stmt.setString(2, member.getEmail());
//      stmt.setString(3, member.getPassword());
//      stmt.setString(4, member.getTel());
//      return stmt.executeUpdate();
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//        System.out.println("stmt 해제실패");
//      }
//      try {
//        con.close();
//      } catch (Exception e) {
//        System.out.println("con 해제실패");
//      }
//    }
//
//  }NAME,EMAIL,PWD,TEL) values(?,?,?,?)");
//      stmt.setString(1, member.getName());
//      stmt.setString(2, member.getEmail());
//      stmt.setString(3, member.getPassword());
//      stmt.setString(4, member.getTel());
//      return stmt.executeUpdate();
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//        System.out.println("stmt 해제실패");
//      }
//      try {
//        con.close();
//      } catch (Exception e) {
//        System.out.println("con 해제실패");
//      }
//    }
//
//  }
//
//  public int update(Member member) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("update MEMBERS set MNAME=? , EMAIL=? , TEL=?, PWD=? where MNO=?");
//      stmt.setString(1, member.getName());
//      stmt.setString(2, member.getEmail());
//      stmt.setString(3, member.getPassword());
//      stmt.setString(4, member.getTel());
//      stmt.setInt(5, member.getNo());
//
//      return stmt.executeUpdate();
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//        System.out.println("stmt 해제실패");
//      }
//      dataSource.returnConnection(con);
//    }
//
//  }
//
//  public int delete(int no) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("delete from MEMBERS where MNO =?");
//      stmt.setInt(1, no);
//      return stmt.executeUpdate();
//    } finally {
//      try {
//        stmt.close();
//      } catch (Exception e) {
//        System.out.println("stmt 해제실패");
//      }
//      dataSource.returnConnection(con);
//    }
//  }

}