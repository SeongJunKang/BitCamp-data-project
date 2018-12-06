/// call by value
package step08$ClassLoading;

public class Exam09 {
  static void setValue(int[] arr ) {

    for(int i = 0  ; i < arr.length ; i ++) {
      arr[i] = i * 100 + 100;
    }

  }
  public static void main(String[] args) {

    int[] arr = new int[3];
    setValue(arr);
    for(int i = 0  ; i < arr.length ; i ++) {
      System.out.println(arr[i]);
    }
  }
}
