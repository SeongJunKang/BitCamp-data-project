// 애노테이션 유지 정책 변경하기
package step27.exam02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//=> 유지 정책을 SOURCE로 변경하자!
//=> 유지 정책을 지정하지 않으면 기본이 CLASS이다.
@Retention(RetentionPolicy.SOURCE)
public @interface Component {
  String value(); // <-- 속성을 정의할 때 메서드처럼 정의한다.
}
