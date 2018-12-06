package step33.exam01;

public class Car {
  String model;
  int cc;
  
  public Car() {
    System.out.println("Car()");
  }

  @Override
  public String toString() {
    return "Car [model=" + model + ", cc=" + cc + "]";
  }
  
  
}
