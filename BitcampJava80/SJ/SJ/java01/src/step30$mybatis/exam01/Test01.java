// SQL mapper Mybatis 적용하기.
package step30$mybatis.exam01;

import java.util.List;

public class Test01 {

  public static void main(String[] args) {

    try {
      Batis mybatis= new Batis("step30$mybatis/exam01/mybatis-config.xml");
      List<Member> list = mybatis.getSqlSession().selectList(
          "MemberDao.selectList");
      for (Member m : list) {
        System.out.println(m);
      }
      mybatis.close();
    } catch (Exception e) {
    }

  }
}

/*
 * # Mybatis  사용 절차 
 * 1)라이브러리 다운로드 및 Classpath에 적용 
 * -> mvnrepository.com 에서 mybatis 검색 
 * -> build.gradle 파일의 의존 라이브러리 블록에 mybatis 정보를 등록한다. 
 * -> gradle eclipse 명령을 실행 이클립스 설정파일을 개정.
 * 
 * 2) mybatis 설정 파일을 준비한다. 
 * -> mybatis.org 사이트에서 설정파일 설명 페이지로 이동. 
 * -> 설정 파일 예제 코드를 복사한다. 
 * -> 패키지에 mybatis 설정파일(mybatis-config.xml) 을 생성하고 복사한 내용을 붙여넣는다. 
 * -> DBMS 정보를 현재 환경에 맞게끔 변경한다.
 *
 * 3) SQL 맵퍼 파일을 준비한다. 
 * -> mybatis.org 사이트의 SQL 맵퍼 파일 설명 페이지로 간다. 
 * -> SQL 맵퍼의 예제 코드 복사. 
 * -> 패키지에 SQL 맵퍼파일(MemberMapper.xml)을 생성하고 복사한 내용을 붙인다. 
 * 
 * 4) SQL 문을 실행할 mybatis 객체를 준비하라. 
 * -> mybatis.org 사이트의 getting started 페이지로 간다.
 * -> sqlsessionFactory 객체를 준비시키는 자바코드를 복사. 
 * -> 이클래스의 메인에 붙여넣는다. 
 * -> mybatis 설정 파일의 경로 정보를 변경.
 */
