package step33$Spring_Ioc.exam08;

import java.util.Date;

public class Car {

  String model;
  String maker;
  Date madeDate;
  Engine engine;
  @Override
  public String toString() {
    System.out.println("toString");
    return "Car [model=" + model + ", maker=" + maker + ", madeDate=" + madeDate + ", engine=" + engine + "]";
  }
  public String getModel() {
    return model;
  }
  public Engine getEngine() {
    return engine;
  }
  public void setEngine(Engine engine) {
    System.out.println("setEngine");
    this.engine = engine;
  }
  public void setModel(String model) {
    System.out.println("setModel");
    this.model = model;
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    System.out.println("setMaker");
    this.maker = maker;
  }
  public Date getMadeDate() {
    return madeDate;
  }
  public void setMadeDate(Date madeDate) {
    System.out.println("setMadeDate");
    this.madeDate = madeDate;
  }
  public Car() {
    System.out.println("car()");
  }
  
}
