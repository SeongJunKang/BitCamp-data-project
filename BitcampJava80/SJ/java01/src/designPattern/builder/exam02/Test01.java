//빌더패턴 적용전.
package designPattern.builder.exam02;


public class Test01 {
   
  public static void main(String[] args) {
    
    CarFactory factory = new CarFactoryBuilder().build("tico,티코2,900;"
        + "sonata,소나타,1999;"
        + "equs,에쿠스골드,3500");
    Car c1 = factory.createCar("tico");
    Car c2 = factory.createCar("sonata");
    Car c3 = factory.createCar("equs");
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(141000*20);
  }
}


/*# 팩토리 메서드 설계 패턴
 * -  객체 생성 과정이 복잡한 경우 , 매번 직접 객체를 생성하기 보다는
 *    메서드를 통해 객체를 얻는 것이 유지보수에 좋다.
 * -  메서드를 통해 객체를 생성하는 설계 방식을 "Factory Method" 패턴이라 부른다.
*/