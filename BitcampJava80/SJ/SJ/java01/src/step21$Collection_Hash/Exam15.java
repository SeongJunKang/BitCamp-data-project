// collection API  - Hash 코드와 Hashmap
// hashcode equals 재정의후
package step21$Collection_Hash;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
public class Exam15 {

  static class Member {
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      // return Integer.toString(this.name.hashCode());// + ", " +this.age;
      return this.name + ", " +this.age;
    }

    @Override
    public int hashCode() {
      return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object other) {
      if (other == null || other.getClass() != this.getClass()) {
        return false;
      }
     Member m = (Member)other;
      if(!this.name.equals(m.name)) {
        return false;
      }
      if(this.age != m.age) {
        return false;
        }
        return true;
      }

    }


  public static void main(String[] args) throws Exception {
    // HashMap <키 , 값>
    HashMap<String, Member> map = new HashMap<>();
    Member m1 = new Member("홍길동",20);
    Member m2 = new Member("임꺽정",30);
    Member m3 = new Member("유관순",16);
    map.put("aaa",m1);
    map.put("bbb",m2);
    map.put("ccc",m3);
    Set entrySet = map.entrySet();     // 리턴값 : [키- 값]의 목록
    Map.Entry<String, Member> entry = null;

    for(Object item : entrySet) {
      // 제네릭을 사용하지 않으면 매번 형변환을 사용해야함.
      entry = (Map.Entry<String , Member>)item;
      System.out.println(entry);
    }
  }
}


/*
*/
