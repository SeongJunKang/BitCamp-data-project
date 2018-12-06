/// call by value
package step08$ClassLoading;

public class Exam08 {
  static void setValue(int a ) {
    a = 30;
  }
  public static void main(String[] args) {

    int a= 10;
    setValue(a);
    System.out.println(a);

  }
}
