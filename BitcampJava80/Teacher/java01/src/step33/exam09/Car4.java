package step33.exam09;

import java.util.Date;

import javax.annotation.Resource;

public class Car4 {
  String model;
  String maker;
  Date madeDate;
  
  @Resource(name="e1") // 자바 기본 애노테이션
  Engine engine;
  
  public Car4() {}

  @Override
  public String toString() {
    return "Car [model=" + model + ", maker=" + maker + ", madeDate=" + madeDate + ", engine=" + engine + "]";
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

  public Date getMadeDate() {
    return madeDate;
  }

  public void setMadeDate(Date madeDate) {
    this.madeDate = madeDate;
  }

  

  
}




