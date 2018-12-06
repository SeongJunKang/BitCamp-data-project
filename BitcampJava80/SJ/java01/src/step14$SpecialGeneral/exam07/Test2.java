// 주제 : 상속과 인스턴스 변수 초기화 순서와 생성자 호출 순서
// 좀더 쉬운 이해를위해 인스턴스 블록을 제외시킴.
package step14$SpecialGeneral.exam07;

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
*/
