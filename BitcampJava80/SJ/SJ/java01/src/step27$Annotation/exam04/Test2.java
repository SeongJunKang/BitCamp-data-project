//특정 애노테이션만 추출하기.
package step27$Annotation.exam04;

import java.lang.annotation.Annotation;

public class Test2 {

  public static void main(String[] args) {
    Class<?> clazz = Member.class;
    Component anno = clazz.getAnnotation(Component.class);
    System.out.println(anno.value());
  }
}

/*
 * Member 클래스에 첨부된 애노테이션 가져오기
 * -단 해당 애노테이션의 유지 정책이 RUNTIME 이어야 가능.
 * 리플랙션 API를 사용.
 */