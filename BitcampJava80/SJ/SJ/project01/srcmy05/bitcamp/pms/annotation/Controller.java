/*
 * 용도 : 명령 처리하는 클래스로 지정할 때 사용.
 */
package bitcamp.pms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
  String value() default "";
}
