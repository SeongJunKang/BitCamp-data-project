// 애노테이션 유지 정책 변경하기2
package step27.exam03;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//=> 유지 정책을 RUMTIME으로 변경하자!
//=> .class 파일에 주석이 포함된다.
//=> 실행할 때 꺼낼 수 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String value();
}
