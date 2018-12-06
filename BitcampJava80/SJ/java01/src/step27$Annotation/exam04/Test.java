package step27$Annotation.exam04;

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
 * Member 클래스에 첨부된 애노테이션 가져오기
 * -단 해당 애노테이션의 유지 정책이 RUNTIME 이어야 가능.
 * 리플랙션 API를 사용.
 */