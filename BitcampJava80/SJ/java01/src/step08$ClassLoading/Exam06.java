// 가비지와 가비지 컬렉터
package step08$ClassLoading;

public class Exam06 {
  public static void main(String[] args) {

    Myclass obj1;        //레퍼런스 변수를 선언할 때는 클래스를 로딩하지 않는다.
    Myclass obj2;
    Myclass obj3;

    obj1 = new Myclass();
    obj2 = new Myclass();
    obj3 = obj1;

    obj3.iv = 100;
    obj3 = obj2;
    obj3.iv = 200;
    obj1 = obj3;

    System.out.printf("%d %d %d \n",obj1.iv,obj2.iv,obj3.iv);

  }
}
