package step33.exam05;

import java.util.Arrays;
import java.util.List;

public class Car {
  String model;
  String maker;
  Engine engine;
  Tire[] tires;
  List<Tire> tires2;
  
  public Car() {
    System.out.println("Car()");
  }

  public void setEngine(Engine engine) {
    System.out.println("setEngine()");
    this.engine = engine;
  }
  
  public void setTires(Tire[] tires) {
    this.tires = tires;
  }
  
  public void setTires2(List<Tire> tires2) {
    this.tires2 = tires2;
  }

  @Override
  public String toString() {
    return "Car [model=" + model + ", maker=" + maker + ", engine=" + engine + ", tires=" + Arrays.toString(tires)
        + ", tires2=" + tires2 + "]";
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




