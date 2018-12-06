// collection API  - Hash 코드와 Hashset
// hashcode equals 재정의전
package step21$Collection_Hash;
import java.util.HashSet;
public class Exam10 {

  static class Member {
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString(){
      return this.name + ", " +this.age;
    }
  }

  public static void main(String[] args) throws Exception {

    HashSet<Member> set = new HashSet<>();
    set.add(new Member("홍길동",20));
    set.add(new Member("임꺽정",30));
    set.add(new Member("유관순",16));
    set.add(new Member("홍길동",20));  //  전부 다 인스턴스를 새로 생성했기 때문에 저장된다.
    set.add(new Member("임꺽정",30));  //  전부 다른 해시코드값을 가진다.

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
