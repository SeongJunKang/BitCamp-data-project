package step25$MethodInfo;

public class Test03 {
  
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
    
    
    
    try {
      
      //1) 클래스 정보 얻기
    Class clazz = Class.forName("step25.Test03$Member");
      //2) 인스턴스 생성하기
    Member m = (Member)clazz.newInstance();
    
    } catch(Exception e){}
    
    
    
  }
}
