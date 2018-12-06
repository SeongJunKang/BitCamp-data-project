// 메서드 호출하기.
package step25$MethodInfo;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LocalVariable;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.Type;

public class Test11 {
  
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
      
      
      //1)인스턴스 생성
      
      JavaClass clazz2 =Repository.lookupClass("step25.Test11$Member");
      Method[] methods = clazz2.getMethods();
      LocalVariable[] vars = null;
      Type[] types = null;
      for (Method m :methods) {
        if(!m.getName().equals("setMember"))
         continue;
        types = m.getArgumentTypes();
        vars = m.getLocalVariableTable().getLocalVariableTable();
        for (int i =1 ; i < vars.length ; i ++) {
          System.out.printf("%s : %s \n",vars[i].getName(),types[i-1].toString());
        }
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