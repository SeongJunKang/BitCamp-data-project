package step33$Spring_Ioc.exam05;

import java.util.Arrays;
import java.util.List;

public class Car {

  String model;
  String maker;
  Tire[] tires;
  List<Tire> tires2;



  public void setTires2(List<Tire> tires2) {
    this.tires2 = tires2;
  }

  @Override
  public String toString() {
    return "Car [model=" + model + ", maker=" + maker + ", tires=" + Arrays.toString(tires) + ", tires2=" + tires2
        + "]";
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


  public void setTires(Tire[] tires) {
    System.out.println("set tires");
    this.tires = tires;
  }

  public Car() {
  }

}
