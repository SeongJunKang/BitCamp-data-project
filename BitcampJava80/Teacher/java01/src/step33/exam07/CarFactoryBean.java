// 주제: 스프링 프레임워크 규칙에 따라 팩토리 클래스 만들기
// => FactoryBean 인터페이스를 구현하면 된다.
// => 스프링에서 팩토리 클래스로 간주할 것이다.
package step33.exam07;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car>{
  /* 1) 객체를 생성할 때 사용할 값은 프로퍼티로 받는다 */
  String model;
  
  public void setModel(String model) {
    System.out.println("setModel()");
    this.model = model;
  }

  public CarFactoryBean() {
    System.out.println("CarFactoryBean()");
  }
  
  /* 2) FactoryBean 인터페이스를 구현한다. */
  @Override
  public boolean isSingleton() {
    System.out.println("isSingleton()");
    return true;
  }
  
  @Override
  public Class<?> getObjectType() {
    System.out.println("getObjectType()");
    return Car.class;
  }
  
  @Override
  public Car getObject() throws Exception {
    System.out.println("getObject()");
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






