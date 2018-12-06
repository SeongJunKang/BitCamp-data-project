// 주제: 오버라이딩(overriding)
package step14.exam05;

public class Test {
  public static void main(String[] args) {
    Sedan c = new Sedan();

    // 수퍼 클래스의 설계도를 보고 만든 메모리
    c.model = "티코";
    c.maker = "비트자동차";
    c.cc = 2000;
    c.capacity = 5;

    // 자신의 설계도를 보고 만든 메모리
    c.isAutomatic = true;
    c.isSunroof = false;

    // 수퍼 클래스로부터 사용 허가를 받은 printInfo() 실행
    // => 서브 클래스(Sedan)에 추가한 속성 값을 출력하지 못한다.
    // => 해결책?
    //    서버로부터 상속받은 메서드를 재정의 한다.
    // => Sedan2와 Test2를 확인하라!
    c.printInfo();
  }
}
