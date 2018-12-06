// collection API  - Hash 코드와 Hashset
// hashcode equals 재정의후
package step21$Collection_Hash;
import java.util.HashMap;
public class Exam14 {

  static class MyKey {
    String value;
    public MyKey(String value) {
      this.value = value;
    }

    @Override
    public int hashCode() {
      return this.value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
      if (other == null || other.getClass() != this.getClass()) {
        return false;
      }

      MyKey m = (MyKey)other;
      if(!this.value.equals(m.value)) {
        return false;
      }
      return true;

    }
  }

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

    Member m1 = new Member("홍길동",20);
    Member m2 = new Member("임꺽정",30);
    Member m3 = new Member("유관순",16);
    // HashMap <키 , 값>
    HashMap<MyKey, Member> set = new HashMap<>();

    MyKey k1 = new MyKey( new String("aaa"));
    MyKey k2 = new MyKey( new String("bbb"));
    MyKey k3 = new MyKey( new String("ccc"));
    MyKey k4 = new MyKey( new String("ddd"));
    MyKey k5 = new MyKey( new String("eee"));

    MyKey kk1 = new MyKey(k1.value);
    MyKey kk2 = new MyKey(k2.value);
    MyKey kk3 = new MyKey(k3.value);
    MyKey kk4 = new MyKey(k4.value);
    MyKey kk5 = new MyKey(k5.value);

    set.put(k1,m1);
    set.put(k2,m2);
    set.put(k3,m3);
    set.put(k4,m1);
    set.put(k5,m2);

    // 키가 다르면 같은 인스턴스를 중복 저장할 수 있다.
    System.out.println(set.get(k1));
    System.out.println(set.get(k2));
    System.out.println(set.get(k3));
    System.out.println(set.get(k4));
    System.out.println(set.get(k5));
    System.out.println();
    System.out.println(set.get(kk1));
    System.out.println(set.get(kk2));
    System.out.println(set.get(kk3));
    System.out.println(set.get(kk4));
    System.out.println(set.get(kk5));
  }
}


/*
# HashSet 이 데이터를 저장하는 방법
- 값을 저장하기 전에 기존에 저장된 객체 중에 같은 값을 가진 객체가 있는지 검사

  - > 검사 방법 ?
    1) Hash code 를 비교
    2) 같은 해시코드를 갖는다면, equals 를 통해 값을 한번 더 비교.

*/
