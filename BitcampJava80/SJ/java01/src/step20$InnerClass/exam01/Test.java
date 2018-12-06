package step20$InnerClass.exam01;

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
