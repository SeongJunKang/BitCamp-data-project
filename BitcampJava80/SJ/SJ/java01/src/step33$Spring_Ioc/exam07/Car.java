package step33$Spring_Ioc.exam07;

import java.util.Map;

public class Car {

  String model;
  String maker;
  Map<String, Object> specs;
  public Car() {
    System.out.println("Car()");
  }
  @Override
  public String toString() {
    return "Car [model=" + model + ", maker=" + maker + ", specs=" + specs + "]";
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public Map<String, Object> getSpecs() {
    return specs;
  }
  public void setSpecs(Map<String, Object> specs) {
    this.specs = specs;
  }

}
