package step30$mybatis.exam03;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Batis {
  private InputStream inputStream;
  private SqlSessionFactory sqlSessionFactory;
  private SqlSession sqlSession;

  public Batis(String path) throws Exception {
    inputStream = Resources.getResourceAsStream(path);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    sqlSession = sqlSessionFactory.openSession();
  }

  public InputStream getInputStream() {
    return inputStream;
  }

  public SqlSessionFactory getSqlSessionFactory() {
    return sqlSessionFactory;
  }

  public SqlSession getSqlSession() {
    return sqlSession;
  }

  public void close() {
    sqlSession.close();
  }
}
