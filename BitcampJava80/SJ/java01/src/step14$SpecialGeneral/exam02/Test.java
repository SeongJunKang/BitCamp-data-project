//주제  : 상속 : 스페셜라이제이션(특화)
package step14$SpecialGeneral.exam02;


public class Test {

  public static void main(String[] args) {

    Sedan c1 = new Sedan();
    Truck t1 = new Truck();

  }
}


/*  Car 라는 클래스를 받아서 좀 더 특별한 클래스를 만든다.
1) 승용차 클래스 만들기 - Sedan 클래스 정의
    + automatic 자동기어조정장치 여부
    + sunroof 여부

2) 짐차 클래스 만들기 - Truck 클래스 정의
    + weight 중량
    + dump 여부


# Specialization  (특화)
- 수퍼클래스를 상속 받아서 기능을 추가하여 하위클래스를 만드는 행위.



*/
