package bitcamp.pms.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
String value() default "";
}
