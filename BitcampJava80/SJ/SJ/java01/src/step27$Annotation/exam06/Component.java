package step27$Annotation.exam06;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 기본값을 지정할 수 있다.
// 기본값이 지정된 경우 속성값을 설정하지 않으면 기본값으로 설정된다.
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String value() default "haha";
  String title(); //<-- 필수 입력 속성
  int no() default 100; // 선택입력속성
}
