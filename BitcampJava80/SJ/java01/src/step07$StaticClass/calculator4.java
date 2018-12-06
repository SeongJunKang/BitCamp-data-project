// 중간 계산 결과를 개별적으로 저장할 변수를 추가하나다.
package step07$StaticClass;
public class calculator4 {
  int result ;

  // 인스턴스 메서드를 실행할 때 넘어오는 인스턴스 주소는
  // 메서드의 감춰진 변수의 this 에 자동 보관된다.
  // 이 메서드를 호출 할 때는 반드시 인스턴스 주소를 줘야한다.
  // 그래서 인스턴스 메서드라 한다.

   void plus(int b) {
    this.result += b;
  }
   void minus(int b) {
    this.result -= b;
  }
   void multiple(int b) {
    this.result *= b;
  }
   void divide(int b) {
    this.result /= b;
  }
}
