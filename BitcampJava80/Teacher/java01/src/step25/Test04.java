// 주제: Reflection API - 메서드 정보 추출하기
package step25;

import java.lang.reflect.Method;

public class Test04 {
  static class Member {
    public static int count;
    
    String name;
    
    public Member() {
      System.out.println("Member()...");
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
  
  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("step25.Test04$Member");
    
    // 메서드 정보 추출
    Method[] methods = clazz.getDeclaredMethods(); // 해당 클래스의 메서드만
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    System.out.println("-------------------------");
    
    methods = clazz.getMethods(); // 상속 받은 public 메서드도 포함
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    System.out.println("-------------------------");
   
  }

}














