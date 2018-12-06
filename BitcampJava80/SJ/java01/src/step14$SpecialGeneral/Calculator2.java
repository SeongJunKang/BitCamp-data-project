/* 기존의 클래스를 상속 받아서 메서드 추가하기.
    class 내클래스 extends 상속받는 기존의 클래스 {
    ....
  }

  용어정리
  - 기존 클래스를 " super class " 또는 "parent class" 라 부른다.
  - 확장하는 클래스를 "sub class" 또는 "child class" 라 부른다.
*/
package step14$SpecialGeneral;


public class Calculator2 extends Calculator{

  
  public void remainder(int a) {

    this.setResult(this.getResult() % a);
  }
  //protected : 같은 패키지, 자식 클래스는 접근 가능.
  protected int abs() {
    return (this.getResult() < 0 )? (-this.getResult()) : (this.getResult()) ;
  }
   int abs2() {
    return (this.getResult() < 0 )? (-this.getResult()) : (this.getResult()) ;
  }
  private int abs3() {
    return (this.getResult() < 0 )? (-this.getResult()) : (this.getResult()) ;
  }


}
