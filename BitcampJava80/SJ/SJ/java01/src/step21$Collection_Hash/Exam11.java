// collection API  - Hash 코드와 Hashset
// hashcode equals 재정의후
package step21$Collection_Hash;
import java.util.HashSet;
public class Exam11 {

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

    HashSet<Member> set = new HashSet<>();
    set.add(new Member("홍길동",20));
    set.add(new Member("임꺽정",30));
    set.add(new Member("유관순",16));
    set.add(new Member("홍길동",20));  //  오버라이드로 해시코드와 이콜을 재정의.
    set.add(new Member("임꺽정",30));  //  인스턴스 해시코드와 상관없이
                                       //  내용이 같으면 같은것으로 재정의

    printList(set);
  }

  static void printList(HashSet<Member> list) {
    System.out.println("-------------------------------");
    for (Object value : list.toArray()) {
      System.out.println(value);
    }
  }
}


/*
# HashSet 이 데이터를 저장하는 방법
- 값을 저장하기 전에 기존에 저장된 객체 중에 같은 값을 가진 객체가 있는지 검사

  - > 검사 방법 ?
    1) Hash code 를 비교
    2) 같은 해시코드를 갖는다면, equals 를 통해 값을 한번 더 비교.

*/
