package step33.exam07;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
  public CarFactory() {
    System.out.println("CarFactory()");
  }
  
  public static Car createCar(String model) {
    Car c = new Car();
    Map<String,Object> specs = new HashMap<>();
    switch (model) {
    case "bitz001":
      specs.put("sunroof", "yes");
      specs.put("cc", 3000);
      specs.put("valve", 16);
    case "bitz002":
      specs.put("sunroof", "yes");
      specs.put("airbag", "quad");
      specs.put("cc", 4500);
      specs.put("valve", 32);
    default:
      specs.put("sunroof", "no");
      specs.put("cc", 800);
    }
    
    c.setSpecs(specs);
    return c;
  }
}






