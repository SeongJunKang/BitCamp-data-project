// 중간 계산 결과를 저장할 공용 변수를 추가
package step07$StaticClass;
public class calculator {

  static int plus(int a, int b) {
    return a + b;
  }
  static int minus(int a, int b) {
    return a - b;
  }
  static int multiple(int a, int b) {
    return a * b;
  }
  static float divide(int a, int b) {
    return (float)a / (float)b;
  }
}
