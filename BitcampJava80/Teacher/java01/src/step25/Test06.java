// 주제: Reflection API - 메서드 정보 추출하기3
// => 패키지 멤버 클래스도 inner 클래스와 같다. 
package step25;

import java.lang.reflect.Method;

public class Test06 {
  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("step25.Member2");
    
    // 메서드 정보 추출
    // => public, protected, (default), private
    Method[] methods = clazz.getDeclaredMethods(); // 해당 클래스의 메서드만
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    System.out.println("-------------------------");
    
    // => public 메서드만
    methods = clazz.getMethods(); // 상속 받은 public 메서드도 포함
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    System.out.println("-------------------------");
   
  }

}














