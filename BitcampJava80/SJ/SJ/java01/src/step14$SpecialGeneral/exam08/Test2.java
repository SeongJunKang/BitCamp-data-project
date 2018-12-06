// 주제 : 수퍼클래스의 생성자호출 확인

package step14$SpecialGeneral.exam08;

public class Test2 {
  public static void main(String[] args) {
    B p = new B();

    System.out.println(p.v1);
    System.out.println(p.v2);
    System.out.println(p.v3);
    System.out.println(p.v4);
    System.out.println(p.v5);

  }
}


/*

new B() 에서 인스턴스 생성 절차
1) A class의 인스턴스 메모리 준비
  v1 - [ null   ]
  v2 - [ 0      ]
  v3 - [ false  ]
2) B class 의 인스턴스 메모리 준비
  v4 - [ 0.0f   ]
  v5 - [ \u0000 ]
3) B 클래스의 생성자 실행.
  -> 내부의 감춰진 수퍼 클래스 생성자 호출 문장을 실행
    - super()  --- >  4) A 클래스의 생성자 실행
                      - super() --> 5) Object 의 생성자 실행
                        6)A의 생성자를 실행.
      7) B의 생성자 실행
8) B의 인스턴스 값 출력


// 자식클래스부터 생성자를 호출하는데, super()가 자식 클래스의 생성자의 맨 첫 문자에 들어가기 때문에
    super() 클래스부터 호출한다.
*/
