/* 주제: call by value */
package step08;

public class Exam08 {
  static void setValue(int a) {
    a = 30;
  }
  public static void main(String[] args) {
    int a = 10;

    setValue(a);

    System.out.println(a);
  }
}

/* call by value
- 메서드를 호출할 때 파라미터에 값을 넘긴다.



*/
