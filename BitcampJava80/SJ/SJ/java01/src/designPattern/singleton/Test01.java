// 싱글톤 패턴 적용
package designPattern.singleton;

public class Test01 {
   
  public static void main(String[] args) {
    CarFactory factory = CarFactory.getInstance();
    CarFactory factory2 = CarFactory.getInstance();
    CarFactory factory3 = CarFactory.getInstance();
    if (factory == factory2 && factory == factory3) {
      System.out.println("factory 1, 2, 3는 같은 인스턴스이다.");
    }
    Car c1 = factory.newCar("tico");
    Car c2 = factory.newCar("sonata");
    System.out.println("c1 = "+c1);
    System.out.println("c2 = "+c2);
  }
}


/*
# 팩토리 메서드 설계 패턴
-  객체 생성 과정이 복잡한 경우 , 매번 직접 객체를 생성하기 보다는
   메서드를 통해 객체를 얻는 것이 유지보수에 좋다.
-  메서드를 통해 객체를 생성하는 설계 방식을 "Factory Method" 패턴이라 부른다.
*/