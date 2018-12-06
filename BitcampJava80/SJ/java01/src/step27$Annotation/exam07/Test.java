//특정 애노테이션만 추출하기.
package step27$Annotation.exam07;

import java.lang.annotation.Annotation;

public class Test {

  public static void main(String[] args) {
    Class<?> clazz = Member.class;
    Annotation[] annos = clazz.getAnnotations();
    for ( Annotation a : annos) {
      System.out.println(a);
    }
    
    Component anno = clazz.getAnnotation(Component.class);
    for (String v : anno.value()) {
    System.out.println(v);
    }
    
    System.out.println();
    
    
    clazz = Member2.class;
    anno = clazz.getAnnotation(Component.class);
    String[] list = anno.value();
    for (String v : list) {
    System.out.println(v);
    }
  }
}
