//특정 애노테이션만 추출하기.
package step27$Annotation.exam06;

import java.lang.annotation.Annotation;

public class Test {

  public static void main(String[] args) {
    Class<?> clazz = Member.class;
    Annotation[] annos = clazz.getAnnotations();
    for ( Annotation a : annos) {
      System.out.println(a);
    }
    
    clazz = Member2.class;
    Component anno = clazz.getAnnotation(Component.class);
    System.out.println(anno.value());
    System.out.println(anno.title());
    System.out.println(anno.no());
    
    
  }
}
