//1) PreparedStatement 적용
//2) DB 연결정보를 외부로부터 받는다.
//   => DBMS 연결 정보가 바뀌더라도 코드를 변경할 필요가 없다.
//3) 커넥션 한 개만 생성하여 공유하기 
//   => 메서드가 호출될 때마다 커넥션을 맺고 실행한 다음 커넥션을 끊으면,
//      실행 속도가 느려진다.
//   => 그래서 DAO를 생성할 때 미리 커넥션을 준비해 두었다가 사용하도록 한다.
//   => 즉, selectList(), insert(), update(), delete()는 커넥션을 공유한다.
package step30.exam03;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {
  SqlSessionFactory sqlSessionFactory;
  
  public MemberDao() {}
  
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
  
  
  public int insert(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.insert("MemberDao.insert", member);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int update(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.update("MemberDao.update", member);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.delete("MemberDao.delete", no);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
}

























