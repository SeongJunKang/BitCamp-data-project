// 주제: equals() 오버라이딩
package step16;

public class Exam04 /*extends Object*/ {
  int age;
  int weight;

  public Exam04(int age, int weight) {
    this.age = age;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "오호라.. 하하하";
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !(other instanceof Exam04))
      return false;

    Exam04 obj = (Exam04)other;

    if (this.age != obj.age)
      return false;

    if (this.weight != obj.weight)
      return false;

    return true;
  }

  public static void main(String[] args) {
    Exam04 p = new Exam04(18, 90);
    Exam04 p2 = new Exam04(18, 90);
    System.out.println(p == p2);
    System.out.println(p.equals(p2));
  }
}
