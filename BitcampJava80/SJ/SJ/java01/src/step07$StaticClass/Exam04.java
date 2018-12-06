/*
각 클래스마다 값을 개별적으로 관리하기
*/
package step07$StaticClass;
//import step07.calculater;
public class Exam04 {
  public static void main(String[] args) {
    //문제 2 * 3 + 6 - 7
    //문제 3 - 7 * 2 + 27

    // 인스턴스 변수 준비
    // new 클래스이름();
    // 해당 클래스의 인스턴스 변수를 조사하여 그 메모리를 준비
    // 그 메모리의 시작주소를 리턴
    // 그 메모리를 "인스턴스" 라고 부른다.
    // 인스턴스 주소를 저장할 변수 선언
    // 클래스이름 변수명 = new 클래스명();
    // 이 변수는 인스턴스의 주소를 저장하기 때문에 레퍼런스 변수라 부른다.
    // 일반적으로 "변수"를 빼고 그냥 "레퍼런스"" 라고 부른다

    //1) 레퍼런스 변수 준비
    // calculator3 calc1;
    //2) 인스턴스(=> "물건(Object)"을 준비
    // calculator3 class 에 인스턴스 변수가 있는지 조사한다.
    // 있다면, 해당 변수에 대해 메모리를 준비한다.
    // 그 메모리의 주소를 리턴한다.
    // calc1 = new calculator3();

    calculator3 calc1 ;
     calc1=new calculator3();
    calculator3 calc2 ;
     calc2=new calculator3();
    calc1.plus(calc1, 2);
    calc2.plus(calc2, 3);
    calc1.multiple(calc1, 3);
    calc2.minus(calc2, 7);
    calc1.plus(calc1, 6);
    calc2.multiple(calc2, 2);
    calc1.minus(calc1, 7);
    calc2.plus(calc2, 27);
    System.out.println(calc1.result); //5
    System.out.println(calc2.result); //19

    //해결책
    // 중간 계산 결과를 개별적으로 관리하면 된다.
    // to be continue.
  }
}

/*

*/
