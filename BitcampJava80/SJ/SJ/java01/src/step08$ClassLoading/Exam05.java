package step08$ClassLoading;

public class Exam05 {
  public static void main(String[] args) {

    int a = 20 ;
    Myclass obj;        //레퍼런스 변수를 선언할 때는 클래스를 로딩하지 않는다.
    obj = new Myclass();

    obj.setIvalue(a);
    obj = new Myclass();

    obj.setIvalue(a);
    System.out.println(obj.iv);


  }

}
