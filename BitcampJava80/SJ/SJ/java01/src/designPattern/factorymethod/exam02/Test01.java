// 일반적인 객체 생성 방법 - new 연산자 사용.
package designPattern.factorymethod.exam02;

public class Test01 {
   
  public static void main(String[] args) {
    CarFactory factory = new CarFactory();
    
    Car c1 = factory.createCar("tico");
    Car c2 = factory.createCar("sonata");
  }
}


/*
# 팩토리 메서드 설계 패턴
-  객체 생성 과정이 복잡한 경우 , 매번 직접 객체를 생성하기 보다는
   메서드를 통해 객체를 얻는 것이 유지보수에 좋다.
-  메서드를 통해 객체를 생성하는 설계 방식을 "Factory Method" 패턴이라 부른다.
*/