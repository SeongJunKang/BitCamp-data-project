package step20$InnerClass.exam03;
public class Outer5 {
  int no ;
  //anonymous inner class - member
  // => new[수퍼클래스 | 인터페이스] (생성자 파라미터,...) {선언}
  Object obj1 = new Object() {};    // Object의 하위 클래스
  Object obj2 = new Object() {};
  Object obj3 = new Object() {};
  void m() {
    System.out.println(obj1);
    System.out.println(obj2);
    System.out.println(obj3);
  }

}
