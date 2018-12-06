package step33.exam12;

import java.util.List;

/* mybatis가 이 DAO 구현체를 자동으로 생성할 것이다.
 * => 규칙
 *    1) 메서드의 이름은 반드시 실행할 SQL 아이디와 같아야 한다.
 *    2) 메서드의 파라미터는 SQL Mapper에 정의된 parameterType과 같아야 한다.
 *    3) 메서드의 리턴 타입은  SQL Mapper에 정의된 resultType과 같아야 한다.
 *    4) SQL 맵퍼 파일의 네임스페이스는 인터페이스의 패키지명과 같아야 한다.
 */
public interface MemberDao {
  List<Member> selectList() throws Exception;
  int insert(Member member) throws Exception;
  int update(Member member) throws Exception;
  int delete(int no) throws Exception;
}

























