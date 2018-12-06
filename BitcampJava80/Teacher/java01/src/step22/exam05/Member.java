package step22.exam05;

public class Member {
  String name;
  int age;
  int height;
  int weight;

  public Member() {
  }

  public Member(String name, int age, int height, int weight) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return this.name + "," + this.age + "," + this.height + "," + this.weight;
  }





}
