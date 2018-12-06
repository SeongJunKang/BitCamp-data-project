//빌더패턴 적용전.
package designPattern.builder.exam01;

import java.util.HashMap;

public class Test01 {
   
  public static void main(String[] args) {
    HashMap<String,Car> carMap = new HashMap<>();
    
    Car c = new Car();
    c.model ="티코";
    c.cc =800;
    carMap.put("tico",c);
    
    c = new Car();
    c.model = "소나타";
    c.cc = 1997;
    carMap.put("sonata", c);
    
    
    CarFactory factory = new CarFactory();
    factory.setCarMap(carMap);
    Car c1 = factory.createCar("tico");
    Car c2 = factory.createCar("sonata");
    Car c3 = factory.createCar("equs");
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
  }
}


/*# 팩토리 메서드 설계 패턴
 * -  객체 생성 과정이 복잡한 경우 , 매번 직접 객체를 생성하기 보다는
 *    메서드를 통해 객체를 얻는 것이 유지보수에 좋다.
 * -  메서드를 통해 객체를 생성하는 설계 방식을 "Factory Method" 패턴이라 부른다.
*/