package step20$InnerClass.exam03;
public class Test1 {

  public static void main(String[] args) {
    Outer2.no = 20 ;
    Outer2.m() ;
    Outer2.Inner.m();
  }
}

/*
중첩 클래스 종류
1) top level inner class
  - static member class
2) member inner class
  - instance member class
3) local inner class
  - 메서드 안에 선언된 클래스
4) anonymous inner class
  - 이름이 없는 클래스. 클래스 선언과 동시에 인스턴스 생성을 해야함
*/
