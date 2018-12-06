package step21$Collection_Hash;
import java.util.ArrayList;
import java.util.Date;

public class Exam01 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add(new Integer(10));
    list.add(new Date());

    for (int i = 0 ; i < list.size() ; i++) {
      System.out.println(list.get(i));
    }
  }
}
