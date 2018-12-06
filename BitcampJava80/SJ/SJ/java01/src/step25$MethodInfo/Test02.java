package step25$MethodInfo;

public class Test02 {
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
    
  }
  public static void main(String[] args) {
    
    Member m = new Member();
    Class clazz1 = m.getClass();
    System.out.println(clazz1.getName());
    
    
    //모든 클래스는 숨겨진 스태틱 변수 "class"가 있다
    // 스태틱 변수 "class"는 해당 클래스의 정보를 가리킨다.
    Class clazz2 = Member.class;   // <-- 파일 확장자 아니다!.
    Member.count = 10;            // <-- class 변수는 count 와 같은 스태틱 변수이다.
    System.out.println(clazz2.getName());
    System.out.println(Member.class.getName());
    try {
      Class clazz3 = Class.forName("step25.Test02$Member");
      System.out.println(clazz3.getName());
    } catch (Exception e){}
  }
}
