/* 기존의 클래스를 상속 받아서 메서드 추가하기.
    class 내클래스 extends 상속받는 기존의 클래스 {
    ....
  }

  용어정리
  - 기존 클래스를 " super class " 또는 "parent class" 라 부른다.
  - 확장하는 클래스를 "sub class" 또는 "child class" 라 부른다.
*/
package step14$SpecialGeneral;


public class Calculator {

  private int result = 0;
  
  public void plus(int a) {
    result += a;
  }
  public void minus(int a) {
    result -= a;
  }
  public void multiple(int a) {
    result *= a;
  }
  public int getResult() {
    return this.result;
  }
  public void setResult(int re) {
    this.result = re;
  }
}
