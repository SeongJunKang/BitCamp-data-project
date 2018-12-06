package step32.exam01;

public abstract class CarFactory {
  
  public static CarFactory newInstance() throws Exception {
    String className = System.getProperty("CarFactory");
    Class<?> clazz = Class.forName(className);
    return (CarFactory)clazz.newInstance();
  }
  
  public abstract Car newCar(String name);
}
