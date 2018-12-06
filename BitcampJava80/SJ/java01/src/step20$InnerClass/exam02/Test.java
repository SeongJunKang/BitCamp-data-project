package step20$InnerClass.exam02;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    for (int i = 0 ; i < list.size() ; i ++ ) {
      System.out.println(list.get(i));
    }
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
