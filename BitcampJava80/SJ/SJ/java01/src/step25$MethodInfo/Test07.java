// 메서드 호출하기.
package step25$MethodInfo;

import java.lang.reflect.Method;

public class Test07 {
  
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
        
  }
  public static void main(String[] args) {
    
    
    try {
      Class<?> clazz = Class.forName("step25.Test07$Member");
     // String 클래스 정보를 얻는 방법
      // 1번 -> "".getClass
      // 2번 -> String.class
      // 3번 -> Calss.forName("java.lang.String")
      //setName(String firstname, String middlename, String lastname)
      Method m1 = clazz.getDeclaredMethod("setName","".getClass(), "".getClass(), "".getClass());
      
        
      //setName(String firstname, String middlename, String lastname)
      Method m2 = clazz.getDeclaredMethod("setName", String.class, String.class, String.class);
     
      
      Method m3 = clazz.getDeclaredMethod("setName",Class.forName("java.lang.String"));   //setName(String name)
       //                    (메서드 이름, 메서드가 원하는 파라미터 타입)
      //clazz.getDeclaredMethod(name,Class<?>... parameterTypes)
    
      
       // 다음과 같이 존재하지 않는 메서드를 찾으려고 한다면 예외가 발생.
      // clazz.getDeclaredMethod("setName",int.class);   
      
      System.out.println(m1);
      System.out.println(m2);
      System.out.println(m3);
      
    } catch(Exception e){}

  }
}

