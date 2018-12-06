package step23;

import java.util.Calendar;
import java.util.ArrayList;

public class HelloJp extends AbstractHello {
  ArrayList<String> list = new ArrayList<String>();

  public HelloJp() {
    list.add("こんにちは。");
    list.add("こんばんは");
  }

  @Override
  public String greet() {
    return sayHello();
  }

  // 이건 기존에 이미 사용한 경우를 대비해서 제거하지 않았음.
  // 나 실력없는 사람 아님!
  public String sayHello() {
    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR);
    if (hour < 18) {
      return list.get(0);
    } else {
      return list.get(1);
    }
  }
}
