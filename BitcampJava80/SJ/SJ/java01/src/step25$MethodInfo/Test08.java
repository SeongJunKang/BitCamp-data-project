// 메서드 호출하기.
package step25$MethodInfo;

import java.lang.reflect.Method;

public class Test08 {
  
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
    
    public void setName(String firstname, String middlename, String lastname) {
      this.name = firstname+" "+middlename+" "+lastname;
    }
    
    @Override
    public String toString() {
      return "Member [name=" + name + "]";
    }
        
  }
  public static void main(String[] args) {
    
    
    try {
      
      
      Class<?> clazz = Class.forName("step25.Test08$Member");
      //1)인스턴스 생성
      Object obj = clazz.newInstance();
      
      //2)메서드 찾기
      Method m1 = clazz.getDeclaredMethod("setName",String.class);
    
      //메서드호출
      //-> 문법 :invoke(인스턴스,값,값,,,)
      // 스태틱 메서드의 경우, 인스턴스 값을 null
      // 인스턴스 메서드의 경우, 반드시 인스턴스 주소를 주어야함.
      m1.invoke(obj, "홍길동");
      System.out.println(obj);
      
      m1 = clazz.getDeclaredMethod("setName",String.class,String.class,String.class);
      m1.invoke(obj, "길동","오호라","홍");
      System.out.println(obj);
      
    } catch(Exception e){}

  }
}

