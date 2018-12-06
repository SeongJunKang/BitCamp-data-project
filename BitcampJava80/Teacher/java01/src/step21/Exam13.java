// 주제: Collection API - HashMap2
// => 사용자 정의 클래스를 key로 사용하기
package step21;

import java.util.HashMap;

public class Exam13 {
  // HashMap에서 key로 사용할 클래스이다.
  static class MyKey {
    String value;

    public MyKey(String value) {
      this.value = value;
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
      return name + "," + age;
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
      if (!this.name.equals(m.name)) return false;
      if (this.age != m.age) return false;
      return true;
    }
  }

  public static void main(String[] args) throws Exception {
    MyKey k1 = new MyKey("aaa");
    MyKey k2 = new MyKey("bbb");
    MyKey k3 = new MyKey("ccc");
    MyKey k4 = new MyKey("ddd");
    MyKey k5 = new MyKey("eee");

    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("임꺽정", 30);
    Member m3 = new Member("유관순", 16);

    // HashMap<키,값> map;
    HashMap<MyKey,Member> map = new HashMap<>();
    map.put(k1, m1);
    map.put(k2, m2);
    map.put(k3, m3);
    map.put(k4, m1); // key가 다르면 같은 인스턴스를 중복 저장할 수 있다.
    map.put(k5, m2); // key가 다르면 같은 인스턴스를 중복 저장할 수 있다.

    MyKey kk1 = new MyKey("aaa");
    MyKey kk2 = new MyKey("bbb");
    MyKey kk3 = new MyKey("ccc");
    MyKey kk4 = new MyKey("ddd");
    MyKey kk5 = new MyKey("eee");

    System.out.printf("k1 == kk2 ? %b\n", k1 == kk1);
    System.out.printf("%d, %d\n", k1.hashCode(), kk1.hashCode());
    System.out.printf("%b\n", k1.equals(kk1));
    System.out.println("-------------------");

    System.out.println(map.get(kk1));
    System.out.println(map.get(kk2));
    System.out.println(map.get(kk3));
    System.out.println(map.get(kk4));
    System.out.println(map.get(kk5));
  }

}

/*
# HashMap에서 값을 꺼낼 때
- 같은 key라면 값을 꺼내 준다.
- 같은 key라는 조건?
  1) 인스턴스가 다르더라도 hashCode()의 값이 같아야 한다.
  2) 인스턴스가 다르더라도 equals()의 값이 같아야 한다.
- 이 예제에서는 MyKey 클래스가 hashCode()와 equals()를
  재정의하지 않았기 때문에, 같은 내용이더라도 다른 키로 취급된다.





*/
