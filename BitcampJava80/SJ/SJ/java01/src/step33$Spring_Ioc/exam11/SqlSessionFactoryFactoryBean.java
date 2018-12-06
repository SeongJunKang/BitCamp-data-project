package step33$Spring_Ioc.exam11;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.FactoryBean;

public class SqlSessionFactoryFactoryBean implements FactoryBean<SqlSessionFactory> {
  
  String configLocation;
  SqlSessionFactory sqlSessionFactory;
  
  public String getConfigLocation() {
    return configLocation;
  }

  public void setConfigLocation(String configLocation) {
    this.configLocation = configLocation;
  }

  @Override
  public SqlSessionFactory getObject() throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(configLocation);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    return sqlSessionFactory;
  }

  @Override
  public Class<?> getObjectType() {
    return SqlSessionFactory.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
  

}
