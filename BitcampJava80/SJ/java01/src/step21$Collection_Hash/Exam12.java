// collection API  - Hash 코드와 Hashset
// hashcode equals 재정의후
package step21$Collection_Hash;
import java.util.HashMap;
public class Exam12 {

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

    String k1 = new String("aaa");
    String k2 = new String("bbb");
    String k3 = new String("ccc");
    String k4 = new String("ddd");
    String k5 = new String("eee");

    Member m1 = new Member("홍길동",20);
    Member m2 = new Member("임꺽정",30);
    Member m3 = new Member("유관순",16);
    Member m4 = new Member("홍길동",20);
    Member m5 = new Member("임꺽정",30);
    // HashMap <키 , 값>
    HashMap<String, Member> set = new HashMap<>();
    set.put(k1,m1);
    set.put(k2,m2);
    set.put(k3,m3);
    set.put(k4,m4);
    set.put(k5,m5);
    // 키가 다르면 같은 인스턴스를 중복 저장할 수 있다.
    System.out.println(set.get("aaa"));
    System.out.println(set.get("bbb"));
    System.out.println(set.get("ccc"));
    System.out.println(set.get("ddd"));
    System.out.println(set.get("eee"));

  }
}


/*
# HashSet 이 데이터를 저장하는 방법
- 값을 저장하기 전에 기존에 저장된 객체 중에 같은 값을 가진 객체가 있는지 검사

  - > 검사 방법 ?
    1) Hash code 를 비교
    2) 같은 해시코드를 갖는다면, equals 를 통해 값을 한번 더 비교.

*/
