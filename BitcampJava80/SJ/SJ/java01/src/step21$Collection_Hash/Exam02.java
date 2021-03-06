package step21$Collection_Hash;
import java.util.ArrayList;
import java.util.Date;

public class Exam02 {
  public static void main(String[] args) {
    ArrayList<Object> list = new ArrayList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add(new Integer(10));
    list.add(new Date());

    System.out.println(list.indexOf("임꺽정"));
    System.out.println(list.indexOf(new String("임꺽정")));
    System.out.println("홍길동" == new String("홍길동"));
    System.out.println(list.contains(new String("홍길동")));
    System.out.println();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("오호라");
    list2.add("큐큐큐");

    list.addAll(list2);
    // for () 레퍼런스 : 배열 또는 collection 타입 객체)
    for(Object element : list) {
      System.out.println(element);
    }
  }
}
