//주제 : 오버라이딩

package step14$SpecialGeneral.exam05;
public class Test2 {
  public static void main(String[] args) {

    Sedan2 s1 = new Sedan2();

    //수퍼클래스 보고 만든 메모리
    s1.model = "티코";
    s1.maker = "비트자동차";
    s1.cc = 2000;
    s1.capacity = 5;

    // 자신의 설계도를 보고 만든 메모리
    s1.isAutomatic = true;
    s1.isSunroof = false;

    //수퍼 클래스로 부터 사용 허가를 받은 printInfo() 실행
    // 서브 클래스 Sedan 에 추가한 속성값을 출력하지 못한다.
    s1.printInfo();

  }
}
/* 상속의 의미 ?
-설계도의 연결을 의미한다.

인스턴스 생성 과정
1) 수퍼 클래스의 설계도를 보고 메모리를 준비한다.
3) 모든 인스턴스 변수값을 초기화
4)만약 초기화 문장이 있다면 실행한다.
  수퍼 클래스 -> 자식 클래스 실행
5) 인스턴스 블록이 있다면 실행한다.
  수퍼 클래스 -> 자식 클래스 실행
6) 자식 클래스 생성자를 실행한다.
  자식 클래스 -> 수퍼 클래스 실행



메서드 실행
1) 인스턴스의 설계도 클래스부터 메서드 찾는다.
2) 만약 없다면 수퍼클래스에서 찾는다.
3)
*/
