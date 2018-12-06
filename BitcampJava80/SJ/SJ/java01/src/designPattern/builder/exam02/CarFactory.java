// 역할 : car 객체를 생성해주는 역할.
package designPattern.builder.exam02;

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
    return carMap.get(name);
  }
}
