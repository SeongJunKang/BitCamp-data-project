package step33$Spring_Ioc.exam01;

public class Car {
  
  String model;
  int cc;
  public Car() {
    System.out.println("car()");
  }
  @Override
  public String toString() {
    return "Car [model=" + model + ", cc=" + cc + "]";
  }
}
