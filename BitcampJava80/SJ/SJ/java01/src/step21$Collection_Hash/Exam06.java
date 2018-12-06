// collection API  - ArrayList 6 -> 익명중첩클래스 적용

package step21$Collection_Hash;
import java.util.ArrayList;
import java.util.Comparator;

public class Exam06 {

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

    // 클래스를 찾아갈 필요없이, 바로 볼 수 있어 코드를 해석하기 쉽다.
    // 인스턴스를 한개만 만들기 때문에 편리하다.
    list.sort(new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.toLowerCase().compareTo(s2.toLowerCase());
      }
    });

    //정렬후
    printList(list);
  }
  static void printList(ArrayList<String> list) {
    for (String value : list) {
      System.out.println(value);
    }
  }
}
