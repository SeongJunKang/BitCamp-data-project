// 역할 : car 객체를 생성해주는 역할.
package designPattern.builder.exam02;

import java.util.HashMap;

public class CarFactoryBuilder {
  public CarFactory build(String blueprint) {
    HashMap<String,Car> carMap = new HashMap<>();
    // key,model,cc ;key,model,cc 
    String[] carInfos = blueprint.split(";");
    for (String carInfo : carInfos) {
      carMap.put(getKey(carInfo),generate(carInfo));
    }
    CarFactory factory = new CarFactory();
    factory.setCarMap(carMap);
    return factory;
  }
  
  private String getKey(String carInfo) {
    return carInfo.split(",")[0]; 
  }
  
  private Car generate(String carInfo) {
    String values[] = carInfo.split(",");
    Car c = new Car();
    if(values.length == 3) {
      c.model = values[1];
      c.cc = Integer.parseInt(values[2]);
      return c;
    }
    return null;
  }
}
