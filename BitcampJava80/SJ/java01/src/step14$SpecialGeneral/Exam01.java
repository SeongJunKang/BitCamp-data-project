//주제  : 상속
package step14$SpecialGeneral;


public class Exam01 {

  public static void main(String[] args) {


    // 기존 클래스 사용 계산 - 연산자 우선순위 아님 , 앞에서부터
    // 2 * 3 - 7 % 3 = ?

    Calculator calc = new Calculator();
    calc.plus(2);
    calc.multiple(3);
    calc.plus(7);
    System.out.println(calc.getResult());
    //  나머지를 구하는 메서드는 없기 때문에
    // 기존클래스로 계산할 수 없다.


    //그래서 기존클래스를 확장한 cal2 를 사용한다.
    Calculator2 calc2 = new Calculator2();
    calc2.plus(2);
    calc2.multiple(3);
    calc2.plus(7);
    calc2.remainder(3);
    System.out.println(calc2.getResult());

  }
}

/* 상속
- 기존 클래스의 기능을 확장하는 문법
- 이점
    => 기존 코드의 재사용
    => 기존 코드를 손대지 않기 때문에 새 기능 추가에 따른 위험도가 덜하다.
    => 기능확장이쉽다.
- 종류
  - 수퍼 클래스에서 하위클래스로 확장하는것을 "specialization"
  - 서브클래스들의 공통점을 뽑아서 수퍼클래스로 정의하는 것을 "generalization"


*/
