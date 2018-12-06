// 메서드 호출하기.
package step25$MethodInfo;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test09 {
  
  public static class Member {
    String name;
    int age;
    float weight;
    float height;
    public void setMember(String name, int age, float weight, float height) {
      this.name = name;
      this.age = age;
      this.weight = weight;
      this.height = height;
      
    }
    @Override
    public String toString() {
      return "Member [name=" + name + ", age=" + age + 
          ", weight=" + weight + ", height=" + height + "]";
    }
    
  }
  public static void main(String[] args) {
    
    
    try {
      
      Class<?> clazz = Class.forName("step25.Test09$Member");
      //1)인스턴스 생성
      Object obj = clazz.newInstance();
      
      //2)메서드 찾기
      Method m = clazz.getDeclaredMethod("setMember",String.class,
          int.class,float.class,float.class);
    
      //3)메서드의 파라미터 알아내기
      Parameter[] params = m.getParameters();
      for (Parameter p : params) {
        System.out.printf("%s : %s \n",p.getName(),p.getType().getName());
      }
      
    } catch(Exception e){
      e.printStackTrace();
    }
    
  }
}

/*
 * 메서드의 파라미터 이름
 * -.class 파일은 각 메서드 별로 로컬 변수 테이블을 갖고 있다.
 * 그 테이블에 메서드의 파라미터 이름이 기록되어 있다.
 * 하지만 리플랙션 API 를 사용하여 그 테이블의 정보를 추출할 수 없다.
 * -해결책 ?
 * 컴파일 옵션을 사용하여 메서드의 파라미터 이름을 .class 파일에 저장하게 해야한다.
 * 그래야만 리플랙션 API를 상용하여 메서드의 파라미터 이름을 알아낼 수 있다.
 * 예 ) -javac -parameters 소스
 * 
 * - 이 방식의 단점
 * 컴파일 할때 -parameters 라는 옵션을 주지 않으면 .class 파일에 메서드 
 * 파라미터 정보가 저장되지 않는다.
 * 일반적으로 개발자들이 컴파일할 때 
 * 따라서 리플랙션 API를 사용하여 
 * 
*/