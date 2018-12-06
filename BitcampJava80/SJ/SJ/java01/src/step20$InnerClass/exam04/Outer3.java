// how to use member inner class.
package step20$InnerClass.exam04;

public class Outer3 {

  int no = 20;
  public void m1() {
    System.out.println("Outer3.m()...");
  }

  public void m2() {
    class Inner {
      int no = 100;
      public void test(int no) {
        System.out.println(Outer3.this.no);     // 이게 원칙
        System.out.println(this.no);            // 클래스명 생략가능
        System.out.println(no);                 // 같은 이름을 갖는 로컬 변수가 없다면,
                                                // this 생략가능.
      }
    }
    Inner p = new Inner();
    p.test(8888);
  }

}
