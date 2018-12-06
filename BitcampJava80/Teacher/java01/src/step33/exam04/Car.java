package step33.exam04;

public class Car {
  String model;
  String maker;
  Engine engine;
  
  public Car() {
    System.out.println("Car()");
  }

  public void setEngine(Engine engine) {
    System.out.println("setEngine()");
    this.engine = engine;
  }

  @Override
  public String toString() {
    return "Car [model=" + model + ", maker=" + maker + ", engine=" + engine + "]";
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    System.out.println("setModel()");
    this.model = model;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    System.out.println("setMaker()");
    this.maker = maker;
  }
  
}




