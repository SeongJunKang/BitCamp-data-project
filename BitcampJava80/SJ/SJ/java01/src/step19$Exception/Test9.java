

package step19$Exception;

public class Test9 {

  public static void main(String[] args) {
    MyClass obj = new MyClass();
    //Exception 예외는 반드시 처리해야 한다.
    //-> try ~catch 로 처리
    //-> 메서드 선언부에 어떤 예외가 발생하는지 명시.
    // 예 ) public static void main(String[] args) throws Exception {

    try{
      obj.m2();
    } catch (Exception e) {
      System.out.println("m2()에서 오류발생!");
    }

//    2) try ~ catch 로 예외 처리를 할 수도 있다.
      // try{
      //   obj.m1();
      // } catch (RuntimeException e) {
      //   System.out.println("m1()에서 오류발생!");
      // }
  }

}


/*
*/
