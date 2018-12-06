package step33$Spring_Ioc.exam07;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
  public CarFactory() {
    System.out.println("CarFactory()");
  }

  public static Car createCar(String model) {
    Car c= new Car();
    Map<String,Object> specs = new HashMap<>();
    switch (model) {
    case "bitz001":
      specs.put("sunpoof","yes");
      specs.put("cc", 3000);
      specs.put("valve", 16);
      break;
    case "bitz002":
      specs.put("sunpoof","yes");
      specs.put("cc", 4500);
      specs.put("valve", 16);
      specs.put("airbag", "quad");
      break;
    default:
      specs.put("cc", 800);
      specs.put("sunpoof","no");
      break;
    }
    c.setSpecs(specs);
    return c;
  }
}
