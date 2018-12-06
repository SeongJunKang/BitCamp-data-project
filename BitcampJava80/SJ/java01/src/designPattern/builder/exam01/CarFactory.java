// 역할 : car 객체를 생성해주는 역할.
package designPattern.builder.exam01;

import java.util.HashMap;


public class CarFactory {
  HashMap<String,Car> carMap = new HashMap<>();

  public HashMap<String, Car> getCarMap() {
    return carMap;
  }
  public void setCarMap(HashMap<String, Car> carMap) {
    this.carMap = carMap;
  }
  public Car createCar(String name) {
    Car c = new Car();
    switch (name) {
    case "tico" :
      c.model = "티코";
      c.cc = 800;
      return c;
    case "sonata" :
      c.model = "소나타";
      c.cc = 1997;
      return c;
    default : 
      return null;
    }
    
  }
}
