package step23;

import java.util.Calendar;
import java.util.ArrayList;

public class HelloJp extends ArrayList<String> implements Hello {
  public HelloJp() {
    this.add("こんにちは。");
    this.add("こんばんは");
  }

  @Override
  public String greet() {
    return this.sayHello(); // 기존 메서드를 손대지 않는다.
  }

  public String sayHello() {
    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR);
    if (hour < 18) {
      return this.get(0);
    } else {
      return this.get(1);
    }
  }
}
