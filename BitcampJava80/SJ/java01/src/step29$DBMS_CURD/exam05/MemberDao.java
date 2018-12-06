package step29$DBMS_CURD.exam05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
  
  DataSource dataSource;
  public MemberDao(DataSource dataSource) {
  this.dataSource = dataSource;

}

  public List<Member> selectList() throws Exception {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Connection con = dataSource.getConnection();
    ArrayList<Member> list = new ArrayList<>();
    try {
      stmt = con.prepareStatement("select * from MEMBERS");
      rs = stmt.executeQuery();
      Member member;
      while (rs.next()) {
        member = new Member();
        member.setNo(rs.getInt("MNO"));
        member.setName(rs.getString("MNAME"));
        member.setEmail(rs.getString("EMAIL"));
        member.setPassword(rs.getString("PWD"));
        member.setTel(rs.getString("TEL"));
        list.add(member);
      }
      return list;
    } finally {
      try {
        rs.close();
      } catch (Exception e) {
        System.out.println("rs 해제실패");
      }
      try {
        stmt.close();
      } catch (Exception e) {
        System.out.println("stmt 해제실패");
      }
      dataSource.returnConnection(con);

    }

  }

  public int insert(Member member) throws Exception {
    PreparedStatement stmt = null;
    Connection con = dataSource.getConnection();
    try {
      stmt = con.prepareStatement("insert into MEMBERS(MNAME,EMAIL,PWD,TEL) values(?,?,?,?)");
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getTel());
      return stmt.executeUpdate();
    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
        System.out.println("stmt 해제실패");
      }
      try {
        con.close();
      } catch (Exception e) {
        System.out.println("con 해제실패");
      }
    }

  }

  public int update(Member member) throws Exception {
    PreparedStatement stmt = null;
    Connection con = dataSource.getConnection();
    try {
      stmt = con.prepareStatement("update MEMBERS set MNAME=? , EMAIL=? , TEL=?, PWD=? where MNO=?");
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getTel());
      stmt.setInt(5, member.getNo());

      return stmt.executeUpdate();
    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
        System.out.println("stmt 해제실패");
      }
      dataSource.returnConnection(con);
    }

  }

  public int delete(int no) throws Exception {
    PreparedStatement stmt = null;
    Connection con = dataSource.getConnection();
    try {
      stmt = con.prepareStatement("delete from MEMBERS where MNO =?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
        System.out.println("stmt 해제실패");
      }
      dataSource.returnConnection(con);
    }
  }
}