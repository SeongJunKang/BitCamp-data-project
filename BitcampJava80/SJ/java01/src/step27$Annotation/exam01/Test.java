package step27$Annotation.exam01;

import java.lang.annotation.Annotation;

public class Test {

  public static void main(String[] args) {
    
    //1)클래스 정보를 가져온다.
    Class<?> clazz = Member.class;
    
    //2) 클래스 정보에서 애노테이션 정보를 꺼낸다.
    Annotation[] annos =clazz.getAnnotations();
    
    //3) 애노테이션 이름을 출력한다.
    
    for (Annotation a : annos) 
      System.out.println(a);
    
  }
}


/*
 * #애노테이션이란
 * 클래스파일에 첨부하는 주석이다
 * 컴파일러나 JVM이 참고할 때 사용한다.
 * 
 * #애노테이션 유지정책(RetentionPolicy)
 * 1) SOURCE
 *  -> source파일에서만 유지된다.
 *  -> 컴파일할 때 제거된다.
 *  -> .class 파일에 존재하지 않는다.
 * 2) Class
 *  -> 컴파일 한 후에 .class 파일에 포함된다
 *  -> JVM이 클래스 로딩할 떄 이 애노테이션 정보를 로딩하지 않는다.
 * 3)Runtime
 *  -> 컴파일 한 후에 .class 파일에 포함된다.
 *  -> JVM이 클래스 로딩할 때 정보도 함께 로딩한다.
 */
