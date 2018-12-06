// 메서드 정보 추출하기.
package step25$MethodInfo;

import java.lang.reflect.Method;

public class Test06 {
  
  public static class Member {
    static int count = 0;
    
    String name;
    public Member() {
      System.out.println("Member()");
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    protected void m1(){}
    void m2(){}
    private void m3(){}
    
  }
  public static void main(String[] args) {
    
    
    try {
      Class<?> clazz = Class.forName("step25.Member2");
      Method[] method = clazz.getDeclaredMethods();   //해당 클래스의 메서드만.
                            //  public , protected, (default), private 
      for (Method m : method) {
        System.out.println(m.getName());
       }
      System.out.println("-------------------------------");
      
      
      method = clazz.getMethods();     // 상속 받은 public 메서드도 포함.
      for (Method m : method) {        // 오로지  public 만.
        System.out.println(m.getName());
       }
      System.out.println("-------------------------------");
    } catch(Exception e){}

  }
}
