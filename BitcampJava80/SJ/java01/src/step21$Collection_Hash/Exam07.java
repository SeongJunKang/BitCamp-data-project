// collection API  - Stack -> 익명중첩클래스 적용

package step21$Collection_Hash;
import java.util.Stack;
import java.util.EmptyStackException;

public class Exam07 {

  public static void main(String[] args) {


    Stack<String> list = new Stack<>();
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
  static void printList(Stack<String> list) {
    System.out.println("-------------------------------");
    while(true) {
      try {
        System.out.println(list.pop());
      } catch (EmptyStackException e) {
        break;
      }
    }
  }
}
