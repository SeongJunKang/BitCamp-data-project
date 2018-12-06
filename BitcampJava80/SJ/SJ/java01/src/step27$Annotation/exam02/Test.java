package step27$Annotation.exam02;

import java.lang.annotation.Annotation;

public class Test {

  public static void main(String[] args) {
    Class<?> clazz = Member.class;
    Annotation[] annos =clazz.getAnnotations();
    for (Annotation a : annos) 
      System.out.println(a);
  }
}

/*
 * #유지 청잭 확인하기
 * - @Component  의 유지 정책이 소스로 변경되었기 때문에
 *    .class 파일에 애노테이션 정보가 포함되지 않을 것이다.
 * - bin 폴더에 가서 Member.class 파일을 확인해보라.
 */