// collection API  - Stack -> 익명중첩클래스 적용

package step21$Collection_Hash;
import java.util.concurrent.ConcurrentLinkedQueue;
public class Exam08 {

  public static void main(String[] args) throws Exception {


    ConcurrentLinkedQueue<String> list = new ConcurrentLinkedQueue<>();
    list.add("111");
    list.add("aaa");
    list.add("444");
    list.add("BBB");
    list.add("222");
    list.add("333");
    list.add("aab");
    list.add("Aac");

    printList(list);
  }
  static void printList(ConcurrentLinkedQueue<String> list) {
    System.out.println("-------------------------------");
    String value ;
    // do {
    //     System.out.println(value);
    // } while ( (value == list.pop()) != null) ;
  }
}
