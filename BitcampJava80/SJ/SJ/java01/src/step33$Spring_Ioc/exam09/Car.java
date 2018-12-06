package step33$Spring_Ioc.exam09;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

  String model;
  String maker;
  Date madeDate;
  Engine engine;
  @Override
  public String toString() {
    return "Car [model=" + model + ", maker=" + maker + ", madeDate=" + madeDate + ", engine=" + engine + "]";
  }
  public String getModel() {
    return model;
  }
  public Engine getEngine() {
    return engine;
  }
  @Autowired
  public void setEngine(Engine engine) {
    this.engine = engine;
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
  public Date getMadeDate() {
    return madeDate;
  }
  public void setMadeDate(Date madeDate) {
    this.madeDate = madeDate;
  }
  public Car() {
  }
  
}
