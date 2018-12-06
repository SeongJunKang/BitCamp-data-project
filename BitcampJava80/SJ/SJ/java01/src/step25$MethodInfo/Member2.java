package step25$MethodInfo;

public class Member2 {
  
    static int count = 0;
    
    String name;
    public Member2() {
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
