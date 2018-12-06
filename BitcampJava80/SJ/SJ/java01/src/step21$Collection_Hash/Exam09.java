// collection API  - Stack -> 익명중첩클래스 적용

package step21$Collection_Hash;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.AbstractCollection;
public class Exam09 {

  public static void main(String[] args) throws Exception {
    ArrayList<String> list = new ArrayList<>();
    list.add("홍길동");
    list.add("유관순");
    list.add("임꺽정");
    list.add("홍길동");
    list.add("유관순");

    HashSet<String> set = new HashSet<>();
    set.add("홍길동");
    set.add("유관순");
    set.add("임꺽정");
    set.add("홍길동");
    set.add("유관순");


    printList(list);
    printList(set);
  }
  static void printList(AbstractCollection<String> list) {
    System.out.println("-------------------------------");
    for (Object value : list.toArray()) {
      System.out.println(value);
    }
  }
}


/*
list
- 데이터 중복을 허용한다.
- 들어간 순서대로 꺼낼수 있다.

set
-데이터 중복을 허용하지 않음
- 저장할 때 인스턴스의 해시코드(hashCode())를 사용한다.
  -> 꺼낼 때 저장한 순서대로 꺼내지지 않는다.


*/
