// 주제 : JVM 아규먼트
package step13$WrapperAutoBoxingDate;


public class Exam08 {

  public static void main(String[] args) {


    String name = System.getProperty("name");
    String age = System.getProperty("age");

    System.out.println(name + " "+ age);
  }
}


/*
JVM 아규먼트 ?
- 자바 프로그래을 실행할 때 JVM 에 넘겨준늑 밧.
예)  java -cp bin -Dname=hong -Dage=18 step13.Exam08
  => name 이라는 이름으로 hong 값을 전달.
  => age 라는 이름을 18값을 전달한다.

*/
