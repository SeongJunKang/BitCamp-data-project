package step28;

public class CarTest {

  public static void main(String[] args) {
    CarFactory factory = new KangnamCarFactory();
    Car car = factory.create();
    
    if (((KangnamCarFactory)factory).isRent()) {
      System.out.println("렌트 가능!");
    }

  }

}
