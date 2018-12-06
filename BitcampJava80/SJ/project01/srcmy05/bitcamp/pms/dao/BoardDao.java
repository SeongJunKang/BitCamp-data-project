package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.domain.Board;

@Component
public class BoardDao {
 
//
//  public void insert(Board board) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("insert into BOARDS(TITLE,CONTS,PWD,CDT) values(?,?,?,now())");
//      stmt.setString(1, board.getTitle());
//      stmt.setString(2, board.getContent());
//      stmt.setString(3, board.getPassword());
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
//  public List<Board> selectList() throws Exception {
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
//    ArrayList<Board> list = new ArrayList<>();
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("select * from BOARDS");
//      rs = stmt.executeQuery();
//      Board board = null;
//      while (rs.next()) {
//        board = new Board();
//        board.setNo(rs.getInt("BNO"));
//        board.setTitle(rs.getString("TITLE"));
//        board.setContent(rs.getString("CONTS"));
//        board.setPassword(rs.getString("PWD"));
//        board.setCreatedDate(rs.getDate("CDT"));
//        board.setView(rs.getInt("VWCNT"));
//        list.add(board);
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
//  public Board selectOne(int no) throws Exception {
//
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("select * from BOARDS where BNO=?");
//      stmt.setInt(1, no);
//      rs = stmt.executeQuery();
//      Board board = null;
//      while(rs.next()) {
//       board= new Board();
//      board.setNo(rs.getInt("BNO"));
//      board.setTitle(rs.getString("TITLE"));
//      board.setContent(rs.getString("CONTS"));
//      board.setPassword(rs.getString("PWD"));
//      board.setCreatedDate(rs.getDate("CDT"));
//      board.setView(rs.getInt("VWCNT"));
//      }
//      return board;
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
//  public int update(Board board) throws Exception {
//    PreparedStatement stmt = null;
//    Connection con = dataSource.getConnection();
//    try {
//      stmt = con.prepareStatement("update BOARDS set TITLE=? , CONTS=? , CDT=now() where BNO=?");
//      stmt.setString(1, board.getTitle());
//      stmt.setString(2, board.getContent());
//      stmt.setInt(3, board.getNo());
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
//      stmt = con.prepareStatement("delete from BOARDS where BNO =?");
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
