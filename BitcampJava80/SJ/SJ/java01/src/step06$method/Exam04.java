/*
값을 리턴하는 메서드 정의하기
*/
package step06$method;

public class Exam04 {

  static String hello(String localecode) {
    switch(localecode){
      case "kor" :
        return "안녕하세요";
      case "jp" :
        return "곤니찌와";
      case "chi" :
        return "니하오";
      default :
        return "hello";
      }
  }
  public static void main(String[] args) {

    System.out.println(hello("kor"));
  }
}

/*

*/
