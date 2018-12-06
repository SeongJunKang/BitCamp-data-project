package step33$Spring_Ioc.exam04;

public class Car {

  String model;
  String maker;
  Engine engine;

  @Override
  public String toString() {
    return "Car [model=" + model + ", maker=" + maker + ", engine=" + engine + "]";
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    System.out.println("set model");
    this.model = model;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    System.out.println("set maker");
    this.maker = maker;
  }

  public void setEngine(Engine engine) {
    System.out.println("set Engine");
    this.engine = engine;
  }

  public Car() {
  }

}
