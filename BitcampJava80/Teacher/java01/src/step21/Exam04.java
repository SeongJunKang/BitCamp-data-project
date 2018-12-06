// 주제: Collection API - ArrayList4
package step21;

import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;

public class Exam04 {
  static class MyComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      return s1.toLowerCase().compareTo(s2.toLowerCase());
    }
  }

  static void printList(ArrayList<String> list) {
    System.out.println("-----------------------");
    for (String element : list) {
      System.out.println(element);
    }
  }
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

    // 정렬 전
    printList(list);

    // 정렬
    MyComparator comp = new MyComparator();
    list.sort(comp);

    // 정렬 후
    printList(list);

  }

}
