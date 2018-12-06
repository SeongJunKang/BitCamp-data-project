package step33$Spring_Ioc.exam09;

import java.util.Date;

import javax.annotation.Resource;

public class Car04 {

  String model;
  String maker;
  Date madeDate;
  
  /*자바 기본 애노테이션*/
  @Resource(name="e1") Engine engine;
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
  public Car04() {
  }
  
}
