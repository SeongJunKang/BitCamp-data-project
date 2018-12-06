// 스프링 IoC 컨테이너(빈 컨테이너) 사용 전 
package step33.exam01;

public class Test01 {

  public static void main(String[] args) {
    Car c = new Car();
    c.model = "티코";
    c.cc = 800;
    System.out.println(c);

  }

}
