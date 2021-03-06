package step21$Collection_Hash;
import java.util.ArrayList;
import java.util.Comparator;

public class Exam03 {

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
    MyComparator comp = new MyComparator();
    list.sort(comp);
    //list.sort(정렬을 판단하는 객체);


    //정렬후
    printList(list);

  }
  static class MyComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      char[] arr1 = s1.toLowerCase().toCharArray();
      char[] arr2 = s2.toLowerCase().toCharArray();
      int cnt = arr1.length - arr2.length < 0 ? arr1.length : arr2.length;
      for (int i = 0 ; i < cnt  ; i++ ) {
        if( arr1[i] < arr2[i] ){
          return -1;
        } else if (arr1[i] > arr2[i]) {
          return 1;
        }
      }
      if(arr1.length == arr2.length) {
        return 0;
      } else if (arr1.length < arr2.length) {
        return -1;
      } else {
        return 1;
      }
    }
  }
  static void printList(ArrayList<String> list) {
    for (String value : list) {
      System.out.println(value);
    }
  }
}
