package step27$Annotation.exam04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 유지정책을 Runtime으로 변경 
// .class 파일에 주석이 포함
// 실행할 때 꺼낼수 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String value();
}
