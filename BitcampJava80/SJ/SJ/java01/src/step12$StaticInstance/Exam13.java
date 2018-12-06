/* 주제 : 파이널 활용*/

package step12$StaticInstance;

public class Exam13 {
  public static void main(String[] args) {

    int result = Car10.plus(20,30);
    System.out.println(result);

  }
}

/*
파라미터 변수 앞에 final 을 붙이는 경우
- 파라미터의 용도는 외부에서 보낸 값을 받는 위함이다.
- 가능한 그 메서드 안에서는 파라미터를 조회용으로만 사용하는 것이 안전하다.
- 이것을 강제시키는 방법으로 파라미터를 final 로 선언한다.
*/
