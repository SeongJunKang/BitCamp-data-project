// Member2를 직렬화(Serialize) 할 수 있도록 지정한다.
package step22.exam05;

import java.io.Serializable;

public class Member2 implements Serializable {
  String name;
  int age;
  int height;
  int weight;
  transient float bmi;
  /* transient
  =>  
  */

  public Member2() {
  }

  public Member2(String name, int age, int height, int weight) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.calculateBMI();
  }

  @Override
  public String toString() {
    return this.name + "," + this.age + "," +
            this.height + "," + this.weight + "," + bmi;
  }

  public void calculateBMI() {
    float h = this.height / 100f;
    this.bmi = this.weight / (h * h);
  }



}
