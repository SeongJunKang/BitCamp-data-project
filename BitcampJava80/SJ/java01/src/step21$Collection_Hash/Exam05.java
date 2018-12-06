// collection API  - ArrayList 5 -> 익명중첩클래스 적용

package step21$Collection_Hash;
import java.util.ArrayList;
import java.util.Comparator;

public class Exam05 {

  public static void main(String[] args) {


    ArrayList<String> list = new ArrayList<>();
    list.add("111");
    list.add("aaa");
    list.add("444");
    list.add("BBB");
    list.add("222");
    list.add("333");
    list.add("aab");
    list.add("Aac");
    ////정렬전
    printList(list);
    System.out.println();

    //정렬
    //list.sort(정렬을 판단하는 객체);
    class MyComparator implements Comparator<String> {
      @Override
      public int compare(String s1, String s2) {
        return s1.toLowerCase().compareTo(s2.toLowerCase());
      }
    }//메인에서만 사용할 클래스라면, 로컬 중첩클래스로 만들어라.
    MyComparator comp = new MyComparator();
    list.sort(comp);
    // 이 코드를 유지보수하는 후임자는 MyComparator가 어떤 일을 하는지 궁금하다
    // 그래서 이 후임자는 위로 스크롤하여 클래스 코드를 확인할 것이다.
    // 확인하고 다시 이 위치로 내려와서 이 코드의 의미를 이해하려고 할것이다.


    //정렬후
    printList(list);
  }
  static void printList(ArrayList<String> list) {
    for (String value : list) {
      System.out.println(value);
    }
  }
}
