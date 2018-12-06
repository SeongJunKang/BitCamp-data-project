package bitcamp.ems.dao;

import java.util.List;
import java.util.Map;

import bitcamp.ems.domain.TeaAssign;
import bitcamp.ems.domain.TeaAssignAdv;

// MemberMapper.xml에 선언된 SQL에 맞추어 메서드를 변경한다.
// => SQL id와 메서드 이름을 같게 한다.
// => SQL parameterType과 메서드의 파라미터 타입을 같게 한다.
// => SQL resultType과 메서드의 리턴 타입을 같게 한다.
// => mybatis는 RuntimeException 예외를 던지기 때문에
//    각 메서드 선언부에 throws 절을 작성할 필요가 없다.

public interface TeaAssignDao {  
  List<TeaAssignAdv> selectList();  
  TeaAssign selectOne(int no);    
  int insert(TeaAssign teaassign);  
  int update(TeaAssign teaassign); 
  int delete(int tano);
  int isMember(Map<String,Object> paramMap);

}
