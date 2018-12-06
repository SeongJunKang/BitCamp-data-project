// 주제: 다시 toString() 오버라이딩
package step16;

public class Exam06 /*extends Object*/ {
  int age;
  int weight;

  public Exam06(int age, int weight) {
    this.age = age;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "[" + this.age + "," + this.weight + "]";
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !(other instanceof Exam06))
      return false;

    Exam06 obj = (Exam06)other;

    if (this.age != obj.age)
      return false;

    if (this.weight != obj.weight)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    StringBuffer buf = new StringBuffer();
    buf.append(Integer.toString(age));
    buf.append(",");
    buf.append(Integer.toString(weight));

    String str = buf.toString();
    int value = str.hashCode();
    return value;
    //return buf.toString().hashCode();
  }

  public static void main(String[] args) {
    Exam06 p = new Exam06(18, 90);
    String v = p.toString(); // "[18,90]"
    System.out.println(v);
    System.out.println(p);

    // 간단하게 p 객체(p 레퍼런스가 가리키는 인스턴스)의
    // 내용을 확인한다.
  }
}

/*
toString() 재정의 하는 이유?
- 간단하게 인스턴스의 값을 확인하고 싶을 때.








*/
