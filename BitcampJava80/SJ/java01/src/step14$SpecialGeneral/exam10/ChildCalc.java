
//주제 :  하위 클래스에서 부모 클래스의 protected 멤버 접근하기.


package step14$SpecialGeneral.exam10;
import step14$SpecialGeneral.Calculator2;


public class ChildCalc extends Calculator2{

  public void testAccess() {
    //1) public 멤버에 접근하기.
    this.remainder(3);

    //2) default 멤버에 접근하기.
    // this.abs2(); // ----> 접근 불가 오류 , 같은 패키지만 접근 가능.

    //3) protected 멤버에 접근하기
    this.abs();     // ----> 접근 가능 , 다른 패키지라도 자식 클래스는 접근가능.

    //4) private 멤버에 접근하기
    //this.abs3();    // ----> 접근 당연히 불가. class 내부에서만 사용할 수 있다.

  }

}

/*
캡슐화 접근 관리
- private   -   그 클래스 내부에서만 접근가능
- default   -   같은 패키지에 소속된 클래스만 접근가능
- protected -   같은 패키지 + 자식 클래스 접근 가능
- public    -   모두접근가능

*/
