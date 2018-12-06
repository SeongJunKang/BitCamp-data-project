// 주제: Collection API - HashMap
package step21;

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
    String k1 = new String("aaa");
    String k2 = new String("bbb");
    String k3 = new String("ccc");
    String k4 = new String("ddd");
    String k5 = new String("eee");

    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("임꺽정", 30);
    Member m3 = new Member("유관순", 16);

    // HashMap<키,값> map;
    HashMap<String,Member> map = new HashMap<>();
    map.put(k1, m1);
    map.put(k2, m2);
    map.put(k3, m3);
    map.put(k4, m1); // key가 다르면 같은 인스턴스를 중복 저장할 수 있다.
    map.put(k5, m2); // key가 다르면 같은 인스턴스를 중복 저장할 수 있다.

    String kk1 = new String("aaa");
    String kk2 = new String("bbb");
    String kk3 = new String("ccc");
    String kk4 = new String("ddd");
    String kk5 = new String("eee");
    
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
