package bitcamp.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.domain.Member;

@Component
public class MemberDao {
  SqlSessionFactory sqlSessionFactory;

  public MemberDao() {
  }

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Member> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("MemberDao.selectList");
    } finally {
      sqlSession.close();
    }
  }

  public Member selectOne(String email) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      HashMap<String, Object> paramMap = new HashMap<>();
      paramMap.put("email", email);
      return sqlSession.selectOne("MemberDao.selectOne", paramMap);
    } finally {
      sqlSession.close();
    }
  }

  public Member selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      HashMap<String, Object> paramMap = new HashMap<>();
      paramMap.put("no", no);
      return sqlSession.selectOne("MemberDao.selectOne", paramMap);
    } finally {
      sqlSession.close();
    }
  }

  public int insert(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.insert("MemberDao.insert", member);
    } finally {
      sqlSession.close();
    }
  }

  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.delete("MemberDao.delete", no);
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

}
