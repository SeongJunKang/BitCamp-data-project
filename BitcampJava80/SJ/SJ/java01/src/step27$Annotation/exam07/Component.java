package step27$Annotation.exam07;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 배열 속성 다루기
// 
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String[] value();

}
