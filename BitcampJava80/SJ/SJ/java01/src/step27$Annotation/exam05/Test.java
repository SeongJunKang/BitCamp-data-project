//특정 애노테이션만 추출하기.
package step27$Annotation.exam05;

import java.lang.annotation.Annotation;

public class Test {

  public static void main(String[] args) {
    Class<?> clazz = Member.class;
    Component anno = clazz.getAnnotation(Component.class);
    System.out.println(anno.value());
  }
}
